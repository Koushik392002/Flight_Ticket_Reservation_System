import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        List<Flight> flights=new ArrayList<>();
        Flight object=new Flight();
        Flight f1=new Flight();
        Flight f2=new Flight();
        flights.add(f1);
        flights.add(f2);
        Scanner sc=new Scanner(System.in);
        String name;
        int id,tickets;
        while(true)
        {
            System.out.println("----------Flight Ticket Reservation System----------");
            System.out.println("1.Book 2.Cancel 3.View Flight Summary 4.Exit");
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.println("Enter your name:");
                name=sc.next();
                System.out.println("Enter your Flight Number:");
                id=sc.nextInt();
                if(id<0 || id>=flights.size())
                {
                    System.out.println("Flight Does not exist");
                    continue;
                }
                System.out.println("Enter the number of Tickets:");
                tickets=sc.nextInt();
                for(int ind=0;ind<flights.size();ind++)
                {
                    if(ind==id)
                    {
                        object=flights.get(ind);
                        if(object.check_ticket_availability(tickets))
                        {
                            System.out.println("Tickets are available,Total Amount and passenger ID will be shared to you shortly");
                            List<Integer> amount_details=new ArrayList<>();
                            amount_details=object.book_ticket(name,tickets);
                            System.out.println("Passenger Id:"+amount_details.get(0));
                            System.out.println("Total Amount Payable:"+amount_details.get(1));
                            continue;
                        }
                        else
                        {
                            System.out.println("Sorry!We are Full");
                            continue;
                        }
                    }
                }
            }
            else if(choice==2)
            {
                System.out.println("Enter Your Flight Number:");
                id=sc.nextInt();
                if(id<0 || id>=flights.size())
                {
                    System.out.println("Flight Does Not Exist");
                }
                else
                {
                    System.out.println("Enter Your Passenger ID:");
                    int passenger_id=sc.nextInt();
                    for(int ind=0;ind<flights.size();ind++)
                    {
                        if(ind==id)
                        {
                            object=flights.get(ind);
                            break;
                        }
                    }
                    if(object.validate_passengerid(passenger_id))
                    {
                        System.out.println("Tickets Cancelled:Amount Refunded Rs."+object.cancel_ticket(passenger_id));
                    }
                    else
                    {
                        System.out.println("Sorry!No Tickets Booked in your name");
                    }
                }
            }
            else if(choice==3)
            {
                System.out.println("Enter Flight ID:");
                id=sc.nextInt();
                if(id<0 || id>=flights.size())
                {
                    System.out.println("No Such Flight Available");
                    continue;
                }
                for(int ind=0;ind<flights.size();ind++)
                {
                    if(ind==id)
                    {
                        object=flights.get(ind);
                        object.get_flight_summary();
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }
        sc.close();
    }
}
