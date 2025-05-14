import axios from 'axios';

const API = axios.create({
  baseURL: process.env.REACT_APP_API_BASE_URL,
  headers: {
    Authorization: `Bearer ${process.env.REACT_APP_ACCESS_TOKEN}`,
  },
});

export default API;
