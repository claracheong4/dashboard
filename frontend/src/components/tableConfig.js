import { textFilter } from "react-bootstrap-table2-filter";

export const columns = [
  {
    dataField: "id",
    text: "Visit ID",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "customerId",
    text: "Customer ID",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "customerName",
    text: "Customer Name",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "ibxId",
    text: "IBX ID",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "ibxName",
    text: "IBX Name",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "country",
    text: "Country",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "region",
    text: "Region",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "startTime",
    text: "Start Time",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "endTime",
    text: "End Time",
    sort: true,
    filter: textFilter(),
  },
  {
    dataField: "purpose",
    text: "Purpose",
    sort: true,
    filter: textFilter(),
  },
];

export const defaultSorted = [
  {
    dataField: "id",
    order: "asc",
  },
];

export const pagingationOptions = {
  sizePerPage: 10,
  hideSizePerPage: true,
  hidePageListOnlyOnePage: true,
};
