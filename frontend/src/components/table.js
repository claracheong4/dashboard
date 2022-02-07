import React from "react";

import BootstrapTable from "react-bootstrap-table-next";
import filterFactory from "react-bootstrap-table2-filter";
import paginationFactory from "react-bootstrap-table2-paginator";

import { columns, defaultSorted, pagingationOptions } from "./tableConfig";
import { compressVisit } from "../util/mapper";

class Table extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rowCount: props.visits.length,
    };
    this.getVisits = this.getVisits.bind(this);
  }

  handleDataChange = ({ dataSize }) => {
    this.setState({ rowCount: dataSize });
  };

  getVisits() {
    return this.props.visits.map(compressVisit);
  }

  render() {
    return (
      <BootstrapTable
        bootstrap4
        onDataSizeChange={this.handleDataChange}
        keyField="id"
        data={this.getVisits()}
        columns={columns}
        defaultSorted={defaultSorted}
        filter={filterFactory()}
        striped
        hover
        bordered={false}
        pagination={paginationFactory(pagingationOptions)}
      />
    );
  }
}

export default Table;
