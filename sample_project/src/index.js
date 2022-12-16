import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Login from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import axios from 'axios';
import Register from './register';

// Used to specify what is the base url and components for those.
axios.defaults.baseURL="http://mumpnaik.altres.com:9003/";
axios.options = {
  headers: {
    "content-type": "application/json;charset=utf-8",
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS'
  }
};
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  //We have to route to different components for that we are using browser route
  //BrowserRouter is a router implementation that uses the HTML5 history API (pushstate, replacestate, and popstate events) to keep your UI in sync with the URL
    <BrowserRouter>
    {/*Holds the multiple routes in this we have to specify which route goes to which component*/}
      <Routes>
        <Route index element={<Login/>}/>
        <Route path='/register' element={<Register/>}/>
      </Routes>
    </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
