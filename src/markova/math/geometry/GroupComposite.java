package markova.math.geometry;

import java.util.ArrayList;
import java.util.List;

public class GroupComposite implements Shiftable
{
    private List<Shiftable> members = new ArrayList<>();

    public void add(Shiftable member){
        members.add(member);
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        for (Shiftable member: members){
            member.shift(coordinate, value);
        }
    }

    @Override
    public String toString() {
        return "GroupComposite{" +
                "members=" + members.toString() +
                '}';
    }
}
