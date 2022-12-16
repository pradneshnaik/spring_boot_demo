import axios from "axios";
import { useEffect, useState } from "react";
import { Alert, Button, Container, Form, FormControl } from "react-bootstrap";

function Register() {

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [department, setDepartment] = useState('');
  const [departments, setDepartments] = useState([]);
  const [success, setSuccess] = useState();

  const validateAndSave = (e) => {
    e.preventDefault();
    const formBody = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      password: password,
      departmentId: department,
    };

    axios.post('student/registerStudent', formBody)
    .then(res => setSuccess(<div key={res.data.result}>{res.data.result}</div>))
    .catch(err => console.log(err));

  }

  // The useEffect Hook allows you to perform side effects in your components.
  // Some examples of side effects are: fetching data, directly updating the DOM, and timers
  useEffect(() => {
    axios.get('department/list')
    .then((resp) => {
      var depts = resp.data;
      setDepartments(depts);
      setDepartment(depts[0].departmentId);
    })
    .catch((err) => {console.log(err)})
  }, []);

  return(
    <Container fluid='md' className="d-flex justify-content-center mt-5">
      <div className="card">
        <div className="card-body">
          <div className="card-title">
            <h1 className="card-title">Register</h1>
            {success && 
              <Alert key={success} variant='success'>{success}</Alert>
            }
            <Form onSubmit={validateAndSave}>
              <Form.Group className="mb-3" controlId="firstName">
                <Form.Label>First Name</Form.Label>
                <FormControl type="input" placeholder="First Name" onChange={(e) => setFirstName(e.target.value)} value={firstName} />
              </Form.Group>
              <Form.Group className="mb-3" controlId="lastName">
                <Form.Label>Last Name</Form.Label>
                <FormControl type="input" placeholder="Last Name" onChange={(e) => setLastName(e.target.value)} value={lastName} />
              </Form.Group>
              <Form.Group className="mb-3" controlId="email">
                <Form.Label>Email</Form.Label>
                <FormControl type="input" placeholder="Email" onChange={(e) => setEmail(e.target.value)} value={email} />
              </Form.Group>
              <Form.Group className="mb-3" controlId="password">
                <Form.Label>Password</Form.Label>
                <FormControl type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} value={password} />
              </Form.Group>
              <Form.Group className="mb-3" controlId="department">
                <Form.Label>Department</Form.Label>
                <Form.Select onChange={(e) => {setDepartment(e.target.value)}} value={department}>
                {
                  departments.map(e =>
                   <option key={e.departmentId} value={e.departmentId}>{e.name}</option>
                  )
                }
                </Form.Select>
              </Form.Group>
              <Button type="submit" variant="primary" size="sm">Save</Button>
            </Form>
          </div>
        </div>
      </div>

    </Container>
  );
}

export default Register;