import axiosClient from "../apiClient";
import { mapVisitFromJson } from "../../util/mapper";

const VISIT_URL = "/visits";

export function getAllVisits(
  id = null,
  startTime = null,
  endTime = null,
  purpose = null
) {
  const params = new URLSearchParams();
  if (id != null) params.append(id);
  if (startTime != null) params.append(startTime.toJSON());
  if (endTime != null) params.append(endTime.toJSON());
  if (purpose != null) params.append(purpose);
  return axiosClient
    .get(VISIT_URL + "?" + params.toString())
    .then((res) => res.data)
    .then((visits) => visits.map(mapVisitFromJson));
}

export function getVisit(id) {
  return axiosClient
    .get(VISIT_URL + "/" + id)
    .then((res) => res.data)
    .then((visit) => mapVisitFromJson(visit));
}

export function postVisit(
  ibx = null,
  customer = null,
  startTime = null,
  endTime = null,
  purpose = null
) {
  return axiosClient
    .post(VISIT_URL, {
      ibx,
      customer,
      startTime: startTime.toJSON(),
      endTime: endTime.toJSON(),
      purpose,
    })
    .then((res) => res.data)
    .then((visit) => mapVisitFromJson(visit));
}

export function putVisit(
  id,
  ibx = null,
  customer = null,
  startTime = null,
  endTime = null,
  purpose = null
) {
  return axiosClient.put(VISIT_URL + "/" + id, {
    ibx,
    customer,
    startTime: startTime.toJSON(),
    endTime: endTime.toJSON(),
    purpose,
  });
}

export function deleteVisit(id) {
  return axiosClient.delete(VISIT_URL + "/" + id);
}
