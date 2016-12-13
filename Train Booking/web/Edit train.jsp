<%-- 
    Document   : Schedule
    Created on : Jun 12, 2016, Jun 12, 2016 10:03:59 PM
    Author     : Hossam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js">

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointments Schedule</title>
    </head>
    <body>
        <FORM action="AppointmentServlet" method="post">
            App_ID<input type="number" name="id"/>
            Appointment Status: 
            <SELECT name="status">
                <OPTION value="pending">pending</option>
                <OPTION value="confirmed">confirmed</option>
                <OPTION value="canceled">canceled</option>
            </SELECT>
            Room Number: 
            room1<INPUT type="checkbox" name="room" value="1"> 
            room2<INPUT type="checkbox" name="room" value="2"> 
            room3<INPUT type="checkbox" name="room" value="3"> 
            room4<INPUT type="checkbox" name="room" value="4"> 
            
            <SELECT name="starttime">
            <OPTION value="400">4:00pm</OPTION>
            <OPTION value="415">4:15pm</OPTION>
            <OPTION value="430">4:30pm</OPTION>
            <OPTION value="445">4:45pm</OPTION>
            <OPTION value="500">5:00pm</OPTION>
            <OPTION value="515">5:15pm</OPTION>
            <OPTION value="530">5:30pm</OPTION>
            <OPTION value="545">5:45pm</OPTION>
            <OPTION value="600">6:00pm</OPTION>
            <OPTION value="615">6:15pm</OPTION>
            <OPTION value="630">6:30pm</OPTION>
            <OPTION value="645">6:45pm</OPTION>
            <OPTION value="700">7:00pm</OPTION>
            <OPTION value="715">7:15pm</OPTION>
            <OPTION value="730">7:30pm</OPTION>
            <OPTION value="745">7:45pm</OPTION>
            <OPTION value="800">8:00pm</OPTION>
            <OPTION value="815">8:15pm</OPTION>
            <OPTION value="830">8:30pm</OPTION>
            <OPTION value="845">8:45pm</OPTION>
            <OPTION value="900">9:00pm</OPTION>
            <OPTION value="915">9:15pm</OPTION>
            <OPTION value="930">9:30pm</OPTION>
            <OPTION value="945">9:45pm</OPTION>
            </SELECT> 
            to 
            <SELECT name="endtime">
            <OPTION value="415">4:15pm</OPTION>
            <OPTION value="430">4:30pm</OPTION>
            <OPTION value="445">4:45pm</OPTION>
            <OPTION value="500">5:00pm</OPTION>
            <OPTION value="515">5:15pm</OPTION>
            <OPTION value="530">5:30pm</OPTION>
            <OPTION value="545">5:45pm</OPTION>
            <OPTION value="600">6:00pm</OPTION>
            <OPTION value="615">6:15pm</OPTION>
            <OPTION value="630">6:30pm</OPTION>
            <OPTION value="645">6:45pm</OPTION>
            <OPTION value="700">7:00pm</OPTION>
            <OPTION value="715">7:15pm</OPTION>
            <OPTION value="730">7:30pm</OPTION>
            <OPTION value="745">7:45pm</OPTION>
            <OPTION value="800">8:00pm</OPTION>
            <OPTION value="815">8:15pm</OPTION>
            <OPTION value="830">8:30pm</OPTION>
            <OPTION value="845">8:45pm</OPTION>
            <OPTION value="900">9:00pm</OPTION>
            <OPTION value="915">9:15pm</OPTION>
            <OPTION value="930">9:30pm</OPTION>
            <OPTION value="945">9:45pm</OPTION>
            <OPTION value="1000">10:00pm</OPTION>
            </SELECT>
            <BR>
            <BR>
            <INPUT type="submit" name="Submit" value="Add Appointment">
        </FORM>
        <table border="1" cellspacing="0">
        <tbody>
        <tr>
        <th align="center" valign="middle" width="80"></th>
        <th align="center" valign="middle" width="100">Room1</th>
        <th align="center" valign="middle">Room2</th>
        <th align="center" valign="middle">Room3</th>
        <th align="center" valign="middle">Room4</th>
        </tr>
        <c:forTokens items="400,415,430,445,500,515,530,545,600,615,630,645,700,715,730,745,800,815,830,845,900,915,930,945" delims="," var="time">
        <fmt:parseNumber var="time" type="number" value="${time}" />
            <tr>
        <td align="center" valign="middle" width="80">
            <c:set var="hour" value="${time/100}" />
            <c:set var="minute" value="${time%100}" />
            <fmt:formatNumber value="${hour}" minFractionDigits="0" maxFractionDigits="0"/>:
            <c:choose>
            <c:when test="${minute!=0}">
                <fmt:formatNumber value="${minute}" minFractionDigits="0" maxFractionDigits="0"/> pm
            </c:when>
            <c:otherwise>
                00 pm
            </c:otherwise>
            </c:choose>
        </td>
        <c:forEach begin="1" end="4" step="1" var="roomNum">
        <td align="center" valign="middle" width="100">
        <c:forEach items="${appointmentschedule.appointments}" var="clazz">
            <c:if test="${clazz.startTime <= time 
            && clazz.endTime > time 
            && clazz.roomNum == roomNum}">
            <c:out value="${clazz.status}" />
            <form action="AppointmentServlet" method="post">
                <input type="hidden" name="id" value="${clazz.ID}" />
                <input type="submit" name="delete" value="Delete">
            </form>
                                    <a href="#galleryImg1"  data-toggle="modal" data-target="#myModal" >

                <input type="submit" id="editbtn" 
                       data-ID ="${clazz.ID}" data-status="${clazz.status}"
                       value="edit"></a>  
            </c:if>
        </c:forEach>
        </td>
        </c:forEach>
        </tr>
        </c:forTokens>
        </tbody>
        </table>
        <div id="dialog-form">
            <h3>ID: <span id="spanDataID" name="ID"></span></h3>
            <h3>Previous status: <span id="spanDatastatus"></span></h3>
            <SELECT name="status">
                <OPTION value="pending">pending</option>
                <OPTION value="confirmed">confirmed</option>
                <OPTION value="canceled">canceled</option>
            </SELECT>
        </div>
        
        
        
        
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h4 class="modal-title"><b>Date : </b></h4> <h4 style="display:inline;"> <div id="date" style="display:inline;"></div> </h4 >
        
      </div>
      <div class="modal-body">
          <h5 style="display:inline;"><b>Description : </b></h5><div id="d" style="display:inline;"></div>
      </div>    
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
    </body>
</html>
