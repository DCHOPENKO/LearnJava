package homeworks.date_time_calendar_api.calendar_app_by_set;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalendarApp {
    private static final Scanner READER = new Scanner(System.in);
    private static CalendarService calendarService = new CalendarService();
    private static int selector;

    public static void main(String[] args) {
        goToStartPage();
    }


    private static void printStartPageHeader() {
        System.out.println("--->>>--- Main Menu ---<<<---");
        System.out.println("1. - Actions with Events");
        System.out.println("2. - Actions with Dates");
    }

    private static void goToStartPage() {
        printStartPageHeader();
        selector = inputIntValue("Input what you want to do");
        switch (selector) {
            case 1:
                goToEventsMngPage();
                break;
            case 2:
                goToDateMngPage();
                break;
            default:
                System.out.println("Incorrect input");
                goToStartPage();
        }

    }

    private static void goToEventsMngPage() {
        printEventsMngPageHeader();
        selector = inputIntValue("Input what you want to do");
        switch (selector) {
            case 1:
                createNewEvent();
                returnToEventsMngPage();
                break;
            case 2:
                editExistEvent();
                returnToEventsMngPage();
                break;
            case 3:
                deleteCurrentEvent();
                returnToEventsMngPage();
                break;
            case 4:
                deleteEventsByDate();
                returnToEventsMngPage();
                break;
            case 5:
                deleteEventsByName();
                returnToEventsMngPage();
                break;
            case 6:
                calendarService.showAllEvents();
                returnToEventsMngPage();
                break;
            case 7:
                goToStartPage();
                break;
            default:
                System.out.println("Incorrect input");
                goToEventsMngPage();
        }

    }

    private static void returnToEventsMngPage() {
        pressAnyKey();
        goToEventsMngPage();
    }

    private static void printEventsMngPageHeader() {
        System.out.println("--->>>--- Events management Menu ---<<<---");
        System.out.println("1. - Create new event");
        System.out.println("2. - Edit event");
        System.out.println("3. - Delete current event");
        System.out.println("4. - Delete all events by Date");
        System.out.println("5. - Delete all events by Name");
        System.out.println("6. - PrintOut all events");
        System.out.println("7. - Go To Main Menu");
    }

    private static void createNewEvent() {
        System.out.println("Firstly Select Date and Time");
        String date = inputText("Input date in format YYYY MM DD HH:mm (2011 03 12 15:34) ");
        String name = inputText("Input Event Name");
        String details = inputText("Input Event Details");
        calendarService.addEventToList(new Event(CalendarService.parseToDateTimeSystemFormat(date), name, details));      //
    }

    private static LocalDateTime checkExistEventByCurrentDate() {
        System.out.println("Firstly Select Date and Time");
        String stringDate = inputText("Input date in format YYYY MM DD (2011 03 12)");
        LocalDateTime date = CalendarService.parseToDateSystemFormat(stringDate);
        calendarService.showEvents(calendarService.collectEventsByDate(date));
        System.out.println("-----------------------------------------------");
        return date;
    }

    private static void editExistEvent() {                                                                                  //
        LocalDateTime date = checkExistEventByCurrentDate();
        String name = inputText("Input Event Name");
        Event existEvent = Event.buildWithDateAndName(date, name);
        if (!calendarService.isEventInList(existEvent)) {                                                          //
            System.out.println("No such events in DB");
            return;
        }
        String updDate = inputText("Input new date in format YYYY MM DD (2011 03 12 12:12)");
        String updName = inputText("Input new name for Event");
        String updDetails = inputText("Input new details for Event");
        Event newEvent = new Event(CalendarService.parseToDateTimeSystemFormat(updDate), updName, updDetails);
        calendarService.editEvent(existEvent, newEvent);
        returnToEventsMngPage();
    }

    private static void deleteCurrentEvent() {
        LocalDateTime date = checkExistEventByCurrentDate();
        String name = inputText("Input Event Name");
        calendarService.deleteEvent(Event.buildWithDateAndName(date, name));
    }

    private static void deleteEventsByDate() {
        LocalDateTime date = checkExistEventByCurrentDate();
        calendarService.deleteAllEventsByDate(date);
    }

    private static void deleteEventsByName() {
        String name = inputText("Input Event Name");
        calendarService.deleteAllEventsByName(name);
    }

    private static void goToDateMngPage() {
        printDateMngPageHeader();
        selector = inputIntValue("Input what you want to do");
        switch (selector) {
            case 1:
                calendarService.printOutDateSystem(calendarService.showCurDateLocal());
                calendarService.showEventsByCurDate(calendarService.showCurDateLocal());
                returnToDateMngPage();
                break;
            case 2:
                printOutCurDateInCustomZone();
                returnToDateMngPage();
                break;
            case 3:
                printParametersForSelectedCity(getDateForCustomCity());
                returnToDateMngPage();
                break;
            case 4:
                printDateAfterXWeeks();
                returnToDateMngPage();
                break;
            case 5:
                printDateAfterXMonths();
                returnToDateMngPage();
                break;
            case 6:
                printDateAfterXYears();
                returnToDateMngPage();
                break;
            case 7:
                printCustomVParams(setCustomParamForOutput());
                returnToDateMngPage();
                break;
            case 8:
                printDataByCuxtomFormat(setFormatForOutput());
                returnToDateMngPage();
                break;
            case 9:
                goToStartPage();
                break;
            default:
                System.out.println("Incorrect input");
                goToDateMngPage();
        }
    }

    private static void printDateMngPageHeader() {
        System.out.println("--->>>--- Dates management Menu ---<<<---");
        System.out.println("1. - Show current date & Time  with all events on current date (Default/Local Timezone)");
        System.out.println("2. - Show current date & Time  with all events on current date (Select any existing Timezone)");
        System.out.println("3. - Choose Country/City and then see for this region time, and day of week");
        System.out.println("4. - show date after X weeks");
        System.out.println("5. - show date after X months");
        System.out.println("6. - show date after X years");
        System.out.println("7. - Set what you want to see and see next info about date (time, date, day of week, number day in year, qty days till NY)");
        System.out.println("8. - Set output format for overview date in console");
        System.out.println("9. - return to main Page");

    }

    private static void returnToDateMngPage() {
        pressAnyKey();
        goToDateMngPage();
    }

    private static void printOutCurDateInCustomZone() {
        String timeZone = inputText("Input TimeZone in format \"GMT+4\"");
        LocalDateTime tenp = calendarService.showCurrentTimeByTZ(CalendarService.getTimeZone(timeZone));
        calendarService.printOutDateSystem(tenp);

    }

    private static ZoneId getDateForCustomCity() {
        String country = inputText("Input Country name");
        String city = inputText("Input City name");
        return calendarService.getTimeZone(country, city);
    }

    private static void printParametersForSelectedCity(ZoneId timeZone) {
        LocalDateTime tenp = calendarService.showCurrentTimeByTZ(timeZone);
        calendarService.printOutTime(tenp);
        calendarService.printOutDayOfWeek(tenp);
    }

    private static void printDateAfterXWeeks() {
        int qtyWeeks = inputIntValue("Input qty weeks which need to roll");
        calendarService.printOutDateSystem(calendarService.goToDateAfterXWeeks(qtyWeeks));
    }

    private static void printDateAfterXMonths() {
        int qtyMonths = inputIntValue("Input qty months which need to roll");
        calendarService.printOutDateSystem(calendarService.goToDateAfterXMonths(qtyMonths));
    }

    private static void printDateAfterXYears() {
        int qtyYears = inputIntValue("Input qty years which need to roll");
        calendarService.printOutDateSystem(calendarService.goToDateAfterXYears(qtyYears));
    }


    private static List<String> setCustomParamForOutput() {
        List<String> list = new ArrayList<>();
        System.out.println("Select which params need to print");
        String shortAnswer = inputText("Need to print Date? answer y (yes) or n (now)");
        if (shortAnswer.equals("y")) {
            list.add("dateFormat");
        }
        shortAnswer = inputText("Need to print Time? answer y (yes) or n (now)");
        if (shortAnswer.equals("y")) {
            list.add("timeFormat");
        }
        shortAnswer = inputText("Need to print Day Of Week? answer y (yes) or n (now)");
        if (shortAnswer.equals("y")) {
            list.add("dayOfWeekFormat");
        }
        shortAnswer = inputText("Need to print number of DAy in current year? answer y (yes) or n (now)");
        if (shortAnswer.equals("y")) {
            list.add("dayNumberInYearFormat");
        }
        shortAnswer = inputText("Need to print qty days till NY? answer y (yes) or n (now)");
        if (shortAnswer.equals("y")) {
            list.add("daysTillNYFormat");
        }
        return list;
    }

    private static void printCustomVParams(List<String> list) {
        for (String str : list) {
            if (str.equals("dateFormat")) {
                calendarService.printOutDate(LocalDateTime.now());
            } else if (str.equals("timeFormat")) {
                calendarService.printOutTime(LocalDateTime.now());
            } else if (str.equals("dayOfWeekFormat")) {
                calendarService.printOutDayOfWeek(LocalDateTime.now());
            } else if (str.equals("dayNumberInYearFormat")) {
                calendarService.printOutNumberDayInYear(LocalDateTime.now());
            } else if (str.equals("daysTillNYFormat")) {
                calendarService.printOutQtyDaysToNY(LocalDateTime.now());
            }
        }
    }

    private static String setFormatForOutput() {
        return inputText("Setup format for output (like - uuuu MM dd Time hh:dd");
    }

    private static void printDataByCuxtomFormat(String formatter) {
        calendarService.printOutDateCustom(LocalDateTime.now(), formatter);
    }


    private static String inputText(String text) {
        System.out.println(text);
        return READER.nextLine();
    }

    private static int inputIntValue(String text) {
        System.out.println(text);
        int inputValue = READER.nextByte();
        READER.nextLine();
        return inputValue;
    }

    private static void pressAnyKey() {
        System.out.println("press Enter to return to previous menu ");
        READER.nextLine();
    }

}
