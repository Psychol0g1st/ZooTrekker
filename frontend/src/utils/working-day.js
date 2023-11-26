export function isWorkingDay(days) {
  // Get the current day of the week
  const currentDate = new Date();
  const currentDay = currentDate.toLocaleDateString('hu-HU', { weekday: 'short' });
  
    days = days.split(',').map(day => day.trim().toLowerCase());

    return days.includes(currentDay.toLowerCase());
}