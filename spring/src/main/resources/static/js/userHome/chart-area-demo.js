// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

let todayDateForDiet = new Date();
let yesterdayDateForDiet = new Date(today.setDate(todayDateForDiet.getDate() -1));
let twoDaysAgoDateForDiet = new Date(today.setDate(yesterdayDateForDiet.getDate() -1));
let threeDaysAgoDateForDiet = new Date(today.setDate(twoDaysAgoDateForDiet.getDate() -1));
let fourDaysAgoDateForDiet = new Date(today.setDate(threeDaysAgoDateForDiet.getDate() -1));
let fiveDaysAgoDateForDiet = new Date(today.setDate(fourDaysAgoDateForDiet.getDate() -1));
let sixDaysAgoDateForDiet = new Date(today.setDate(fiveDaysAgoDateForDiet.getDate() -1));


// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: [sixDaysAgoDateForDiet.getMonth() + 1 + "/" + sixDaysAgoDateForDiet.getDate(),
      fiveDaysAgoDateForDiet.getMonth() + 1 + "/" + fiveDaysAgoDateForDiet.getDate(),
      fourDaysAgoDateForDiet.getMonth() + 1 + "/" + fourDaysAgoDateForDiet.getDate(),
      threeDaysAgoDateForDiet.getMonth() + 1 + "/" + threeDaysAgoDateForDiet.getDate(),
      twoDaysAgoDateForDiet.getMonth() + 1 + "/" + twoDaysAgoDateForDiet.getDate(),
      yesterdayDateForDiet.getMonth() + 1 + "/" + yesterdayDateForDiet.getDate(),
      todayDateForDiet.getMonth() + 1 + "/" + todayDateForDiet.getDate()
    ],
    datasets: [{
      label: "Sessions",
      lineTension: 0.3,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,117,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
      data: [31274, 33259, 25849, 24159, 32651, 31984, 38451],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 40000,
          maxTicksLimit: 5
        },
        gridLines: {
          color: "rgba(0, 0, 0, .125)",
        }
      }],
    },
    legend: {
      display: false
    }
  }
});
