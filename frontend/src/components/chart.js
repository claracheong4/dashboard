import React, { useState, useCallback } from "react";

import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ResponsiveContainer,
} from "recharts";

const Chart = ({ visitCount }) => {
  const [opacity, setOpacity] = useState({
    hour: 1,
    count: 1,
  });

  const handleMouseEnter = useCallback(
    (o) => {
      const { dataKey } = o;

      setOpacity({ ...opacity, [dataKey]: 0.5 });
    },
    [opacity, setOpacity]
  );

  const handleMouseLeave = useCallback(
    (o) => {
      const { dataKey } = o;
      setOpacity({ ...opacity, [dataKey]: 1 });
    },
    [opacity, setOpacity]
  );

  const CustomTooltip = ({ active, payload, label }: any) => {
    if (active && payload && payload.length) {
      return (
        <div className="custom-tooltip">
          <p>{`hour : ${label}`}</p>
          <p>{`count : ${payload[0].value}`}</p>
        </div>
      );
    }

    return null;
  };

  return (
    <div className="chart">
      <div className="chart-container">
        <ResponsiveContainer
          width="99%"
          height="99%"
          minHeight={500}
          minWidth={400}
        >
          <LineChart
            width={600}
            height={400}
            margin={{
              top: 20,
              right: 20,
              bottom: 20,
              left: 20,
            }}
            data={visitCount}
          >
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis type="number" dataKey="hour" name="hour" />
            <YAxis type="number" dataKey="count" name="visits" />
            <Tooltip
              content={<CustomTooltip />}
              cursor={{ strokeDasharray: "3 3" }}
            />
            <Legend
              onMouseEnter={handleMouseEnter}
              onMouseLeave={handleMouseLeave}
            />
            <Line
              type="monotone"
              name="Number of Visitors"
              dataKey="count"
              strokeOpacity={opacity.pv}
              stroke="#0d6efd"
              activeDot={{ r: 8 }}
            />
          </LineChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
};

export default Chart;
