import axiosClient from "../apiClient";

const CUSTOMER_URL = "/customers";

export function getAllCustomers(id = null, name = null) {
  const params = new URLSearchParams();
  if (id != null) params.append(id);
  if (name != null) params.append(name);
  return axiosClient
    .get(CUSTOMER_URL + "?" + params.toString())
    .then((res) => res.data);
}

export function getCustomer(id) {
  return axiosClient.get(CUSTOMER_URL + "/" + id).then((res) => res.data);
}

export function postCustomer(name) {
  return axiosClient.post(CUSTOMER_URL, { name }).then((res) => res.data);
}

export function putCustomer(id, name = null) {
  return axiosClient
    .put(CUSTOMER_URL + "/" + id, { name });
}

export function deleteCustomer(id) {
  return axiosClient.delete(CUSTOMER_URL + "/" + id);
}
