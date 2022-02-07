function timeOverlap(currTime, startTime, endTime) {
  return currTime >= startTime && currTime <= endTime;
}

export function getCurrentVisitCount(visits) {
  var currTime = new Date();
  return visits.filter((visit) =>
    timeOverlap(currTime, visit.startTime, visit.endTime)
  ).length;
}

function matchDate(date1, date2) {
  return (
    date1.getFullYear() === date2.getFullYear() &&
    date1.getMonth() === date2.getMonth() &&
    date1.getDate() === date2.getDate()
  );
}

export function getTodayVisitCount(visits) {
  var currentTime = new Date();
  return visits.filter(
    (visit) =>
      matchDate(currentTime, visit.startTime) ||
      matchDate(currentTime, visit.endTime)
  ).length;
}

export function getVisitsCountByHour(visits) {
  let visitCount = new Array(24);
  for (let i = 0; i < 24; i++) {
    visitCount[i] = { hour: i, count: 0 };
  }
  visits.forEach((visit) => {
    const startHour = visit.startTime.getHours();
    const endHour = visit.endTime.getHours();
    for (let i = startHour; i <= endHour; i++) {
      visitCount[i].count++;
    }
  });
  return visitCount;
}
