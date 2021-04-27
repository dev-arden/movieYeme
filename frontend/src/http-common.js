import axios from 'axios'

export default axios.create({
  baseURL: 'http://localhost:8080/',
  headers: {
    // 'withCredentials': true,
    // 'Access-Control-Allow-Origin' : '*',
    // 'Access-Control-Allow-Headers' : '*',
    'Content-type': 'application/json'
  }
})