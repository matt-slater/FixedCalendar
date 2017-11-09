# FixedCalendar
A Webapp that displays the current date on the International Fixed Calendar

## What does it do?

This was a project I started to learn how JSPs and servlets worked. At the time, I was interested in an alternative calendar called the International Fixed Calendar. I wanted to see if I could represent this calendar in Java, but there was already a solution. I used a library called ThreeTen-Extra which was written by the author of the Java 8 date and time library. It includes specialized classes that aren't fit for the major Java releases. 

1. The user makes a GET request to the servlet.
2. The servlet uses ThreeTen's International Fixed Date to get the current date.
3. There is logic to turn the series of numbers into a human readable form.
4. The day, month and date are added to the response as attributes.
5. The response is forwarded to the JSP, where the attributes are rendered to the user in the browser.
