import axios from "axios";

const axiosClient = axios.create({
  baseURL: "http://localhost:8080/",
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

axiosClient.interceptors.response.use(
  function (response) {
    return response;
  },
  function (error) {
    let res = error.response;
    console.error("Status Code: " + res.status);
    return Promise.reject(error);
  }
);

export default axiosClient;
