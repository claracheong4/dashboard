import React, { Component } from "react";

import { Container, Row, Col, Card } from "react-bootstrap";

import { getAllVisits } from "../network/lib/visit";

import {
  getCurrentVisitCount,
  getTodayVisitCount,
  getVisitsCountByHour,
} from "../util/stats";

import Chart from "./chart";
import Header from "./header";
import Table from "./table";
import VisitCountCard from "./visitCountCard";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      visits: [],
    };
    this.getVisitsInfo = this.getVisitsInfo.bind(this);
  }

  getVisitsInfo() {
    getAllVisits().then((visits) => {
      this.setState({ visits });
    });
  }

  componentDidMount() {
    this.getVisitsInfo();
  }

  render() {
    const { visits } = this.state;
    return (
      <div className="text-center">
        <Header />
        <Container fluid>
          <Row className="p-2">
            <Col xs={6} md={4}>
              <VisitCountCard
                currentCount={getCurrentVisitCount(visits)}
                totalCount={getTodayVisitCount(visits)}
              />
            </Col>
            <Col xs={12} md={8}>
              <Card bd="light">
                <Chart visitCount={getVisitsCountByHour(visits)} />
              </Card>
            </Col>
          </Row>
          <Row className="p-2">
            <Table visits={visits} />
          </Row>
        </Container>
      </div>
    );
  }
}

export default App;
