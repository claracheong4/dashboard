import { Card } from "react-bootstrap";

const VisitCountCard = ({ currentCount, totalCount }) => {
  return (
    <Card className="text-center">
      <Card.Header as="h3">Visitor Traffic</Card.Header>

      <Card.Body className="text-primary">
        <Card.Text as="h1">{currentCount}</Card.Text>
        <Card.Title>Active Visits</Card.Title>
      </Card.Body>

      <Card.Body className="text-muted">
        <Card.Text as="h2">{totalCount}</Card.Text>
        <Card.Title>Visits Today</Card.Title>
      </Card.Body>
    </Card>
  );
};

export default VisitCountCard;
