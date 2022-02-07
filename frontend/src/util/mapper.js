export function mapVisitFromJson(visit) {
  visit.startTime = new Date(visit.startTime);
  visit.endTime = new Date(visit.endTime);
  return visit;
}

export function mapVisitToJson(visit) {
  visit.startTime = visit.startTime.toJSON();
  visit.endTime = visit.endTime.toJSON();
  return visit;
}

export function compressVisit(visit) {
  visit.customerId = visit.customer.id;
  visit.customerName = visit.customer.name;

  visit.ibxId = visit.ibx.id;
  visit.ibxName = visit.ibx.name;
  visit.country = visit.ibx.country;
  visit.region = visit.ibx.region;

  visit.startTime = new Date(visit.startTime).toLocaleString();
  visit.endTime = new Date(visit.endTime).toLocaleString();
  return visit;
}
