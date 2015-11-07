package fixedcal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.threeten.extra.chrono.*;

import java.time.*;
import java.time.temporal.ChronoField;



/**
 * Servlet implementation class CalendarServlet
 */

public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String[] months = {"January", "February", "March", "April", "May", "June",
			"Sol", "July", "August", "September", "October", "November", "December"};
	private String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday",
			"Thursday", "Friday", "Saturday"};
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InternationalFixedDate ifd = InternationalFixedDate.now();
		int month = (int) ifd.getLong(ChronoField.MONTH_OF_YEAR);
		int date = (int) ifd.getLong(ChronoField.DAY_OF_MONTH);
		int day = (int) ifd.getLong(ChronoField.DAY_OF_WEEK);
		if (month==6 && date==29) {
			request.setAttribute("day", "Leap Day");
		} else if (month==13 && date==29) {
			request.setAttribute("day", "Year Day");
		} else {
			request.setAttribute("month", months[month-1]);
			request.setAttribute("date", date);
			request.setAttribute("day", weekdays[day-1]);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("today.jsp");
		dispatcher.forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
