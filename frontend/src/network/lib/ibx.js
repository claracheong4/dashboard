import axiosClient from "../apiClient";

const IBX_URL = "/ibxs";

export function getAllIbxs(
  id = null,
  name = null,
  country = null,
  region = null
) {
  const params = new URLSearchParams();
  if (id != null) params.append(id);
  if (name != null) params.append(name);
  if (country != null) params.append(country);
  if (region != null) params.append(region);
  return axiosClient
    .get(IBX_URL + "?" + params.toString())
    .then((res) => res.data);
}

export function getIbx(id) {
  return axiosClient.get(IBX_URL + "/" + id).then((res) => res.data);
}

export function postIbx(name, country, region) {
  return axiosClient
    .post(IBX_URL, { name, country, region })
    .then((res) => res.data);
}

export function putIbx(id, name = null, country = null, region = null) {
  return axiosClient
    .put(IBX_URL + "/" + id, { name, country, region });
}

export function deleteIbx(id) {
  return axiosClient.delete(IBX_URL + "/" + id);
}
