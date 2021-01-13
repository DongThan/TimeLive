<%-- 
    Document   : countdown
    Created on : Jan 12, 2021, 7:56:01 PM
    Author     : KHOAPHAN
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="Model.*"%>
<%@page import="DAO.*"%>
<%@page import="Hibernate.HibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Countdown</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/sidebar.css" rel="stylesheet" type="text/css"/>
        <link href="css/calendar.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="http://cdn.rawgit.com/hilios/jQuery.countdown/2.2.0/dist/jquery.countdown.min.js"></script>
        <link href="css/count.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
    <%
    Users user = (Users)session.getAttribute("user");
    if(user == null ){ %>
    <jsp:forward page="login.jsp"/>
    <% }
    String a = user.getEmail();
    %>
    <div class="page-wrapper chiller-theme toggled">
      <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
        <i class="fas fa-bars"></i>
      </a>
      <nav id="sidebar" class="sidebar-wrapper">
        <div class="sidebar-content">
          <div class="sidebar-brand">
            <a href="#">pro sidebar</a>
            <div id="close-sidebar">
              <i class="fas fa-times"></i>
            </div>
          </div>
          <div class="sidebar-header">
            <div class="user-pic">
              <img class="img-responsive img-rounded" src="https://raw.githubusercontent.com/azouaoui-med/pro-sidebar-template/gh-pages/src/img/user.jpg"
                alt="User picture">
            </div>
            <div class="user-info">
              <span class="user-name">
                <strong><%=user.getFullname()          %></strong>
              </span>
              <span class="user-role"><%=user.getEmail()            %></span>
              <span class="user-status">
                <i class="fa fa-circle"></i>
                <span>Online</span>
              </span>
            </div>
          </div>
          <div class="sidebar-menu">
            <ul>
                <li class="header-menu">
                  <span>General</span>
                </li>
                <li class="sidebar-dropdown">
                  <a href="dashboard.jsp">
                    <i class="fa fa fa-tachometer"></i>
                    <span>Dashboard</span>
                    <span class="badge badge-pill badge-warning">New</span>
                  </a>
                </li>
                <li class="sidebar-dropdown">
                  <a href="todo.jsp">
                    <i class="fa fa-pencil-square-o"></i>
                    <span>Todo</span>
                    <span class="badge badge-pill badge-danger">3</span>
                  </a>
                </li>
                <li class="sidebar-dropdown">
                  <a href="task.jsp">
                    <i class="fa fa-tasks"></i>
                    <span>Task</span>
                  </a>
                </li>
                <li class="sidebar-dropdown">
                  <a href="routine.jsp">
                    <i class="fa fa-repeat"></i>
                    <span>Routine</span>
                  </a>
                </li>
                <li class="sidebar-dropdown">
                  <a href="statistic.jsp">
                    <i class="fa fa-chart-line"></i>
                    <span>Statistic</span>
                  </a>

                </li>
                <li class="header-menu">
                  <span>Extra</span>
                </li>
                <li>
                  <a href="#">
                    <i class="fa fa-book"></i>
                    <span>Account</span>
                    <span class="badge badge-pill badge-primary">Beta</span>
                  </a>
                </li>
                <li>
                  <a href="calander.jsp">
                    <i class="fa fa-calendar"></i>
                    <span>Calendar</span>
                  </a>
                </li>
                <li>
                  <a href="countdown.jsp">
                    <i class="fa fa-clock-o"></i>
                    <span>Countdown</span>
                  </a>
                </li>
            </ul>
          </div>
          <!-- sidebar-menu  -->
        </div>
    <!-- sidebar-content  -->
    <div class="sidebar-footer">
        <a>
            <i class="fa fa-cog"></i>
            <span class="badge-sonar"></span>
        </a>
        <a href="#">
            <i class="fa fa-power-off"></i>
        </a>
        
    </div>
        
  </nav>
              
  <main class="page-content">
    <div class="countdown">
    <div class="heading">
      <p>CÙNG ĐẾM NGƯỢC NĂM MỚI CÙNG CHÚNG MÌNH NHÉ !! </p>
      <br>
      <h2>Thời gian đếm ngược còn :</h2>
    </div>
    
    <div class="timer">
      <p id="day"></p>
      <h6>Ngày</h6>
    </div>
  
    <div class="timer">
      <p id="hour"></p>
      <h6>Giờ</h6>
    </div>
  
    <div class="timer">
      <p id="minute"></p>
      <h6>Phút</h6>
    </div>
    <div class="timer">
      <p id="second"></p>
      <h6>Giây</h6>
    </div>
    <script>
  
  var countDownDate = new Date("February 12, 2021 00:00:00").getTime();
  var x = setInterval(function() {

  var now = new Date().getTime();
  var distance = countDownDate - now;


  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
  
  document.getElementById("day").innerHTML = days;
  document.getElementById("hour").innerHTML = hours;
  document.getElementById("minute").innerHTML = minutes;
  document.getElementById("second").innerHTML = seconds;
  });

</script>
  </div>
  </main>
  <!-- sidebar-wrapper  -->
  <!-- page-content" -->
</div>
<!-- page-wrapper -->
    
    
</body>
</html>
