import { useState } from "react";
import { Anchor, Button, Container, Form, FormControl, Row, Col, Alert } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css"
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Login() {
  // The useState() is a Hook that allows you to have state variables in functional components
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorArr, setErrorArr] = useState([]);
  //useNavigation is a hook which gives access to navigation object
  const nav = useNavigate();

  const reqBody = {
    email: email,
    password: password
  };

  const validateAndSubmit = async (e) => {
    var err = []
    e.preventDefault();
    if(email.length === 0) {
      err.push(<Alert key={err.length} variant='danger'>No email</Alert>);
    }
    if(password.length === 0) {
      err.push(<Alert key={err.length} variant='danger'>No Pass</Alert>);
    }

    if(err.length === 0) {
      try{
        // Call post method.
      let res = await axios.post('student/authenticate', reqBody);
      err.push(<Alert key={err.length} variant='danger'>{res.data.result}</Alert>);
      }
      catch(error) {
      }
    }

    setErrorArr(err);

  };

  const goToRegister = (e) => { 
    e.preventDefault();
    nav('/register')
  }

  // This return renders the whole page from jsx to html.
  return (
    <Container fluid='md' className="d-flex justify-content-center mt-5">
      <div className="card">
          <div className="card-body">
            <h1 className="card-title">Login</h1>
            {errorArr}
            <Form onSubmit={validateAndSubmit}>
              <Form.Group className="mb-3" controlId="email">
                {/** unlike html, we need to set values in react using onchange and by default react passes event as a parameter. */}
                <FormControl type="input" onChange={(e) => setEmail(e.target.value)} value={email} placeholder="Email"/>
              </Form.Group>
              <Form.Group className="mb-3" controlId="password">
                <FormControl type="password" onChange={(e) => setPassword(e.target.value)} value={password} placeholder="Password"/>
              </Form.Group>
              <Row>
                <Col>
                  <Button type="submit" variant="secondary" size="sm">Login</Button>
                </Col>
                <Col>
                  <Anchor className="text-right" onClick={goToRegister}>Register</Anchor>
                </Col>
              </Row>
            </Form>
          </div>
      </div>
    </Container>
  );
}

export default Login;
