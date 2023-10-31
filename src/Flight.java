import java.util.*;
public class Flight {
    static int id=0;
    int tickets_available;
    List<String> passenger_names;
    List<Integer> passenger_id;
    List<Integer> tickets;
    List<Integer> cost;
    int ticket_price;
    public Flight()
    {
        ticket_price=1000;
        tickets_available=50;
        passenger_names=new ArrayList<>();
        passenger_id=new ArrayList<>();
        tickets=new ArrayList<>();
        cost=new ArrayList<>();
    }

    public boolean check_ticket_availability(int tic)
    {
        if(tickets_available>=tic)
        {
            return true;
        }
        return false;
    }

    public List<Integer> book_ticket(String name,int tic)
    {
        int amount=0;
        List<Integer> ans=new ArrayList<>();
        amount+=tic*ticket_price;
        ticket_price+=(200*tic);
        id++;
        passenger_names.add(name);
        passenger_id.add(id);
        cost.add(amount);
        tickets_available-=tic;
        tickets.add(tic);
        ans.add(id);
        ans.add(amount);
        return ans;
    }

    public void get_flight_summary()
    {
        for(int ind=1;ind<=passenger_names.size();ind++)
        {
            System.out.printf("Passenger %d\n",ind);
            System.out.println("Passenger Name:"+passenger_names.get(ind-1));
            System.out.println("Passenger ID:"+passenger_id.get(ind-1));
            System.out.println("Tickets Booked:"+tickets.get(ind-1));
            System.out.println("Total Amount Paid:"+cost.get(ind-1));
        }   
    }

    public boolean validate_passengerid(int id)
    {
        if(passenger_id.contains(id))
        {
            return true;
        }
        return false;
    }

    public int cancel_ticket(int id)
    {
        int ind=passenger_id.indexOf(id);
        passenger_id.remove(ind);
        passenger_names.remove(ind);
        int temp=tickets.get(ind);
        tickets_available+=temp;
        tickets.remove(ind);
        temp=cost.get(ind);
        cost.remove(ind);
        return temp;
    }
}
