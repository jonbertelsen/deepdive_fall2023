package dat;

import java.util.ArrayList;
import java.util.List;

public class ProductList
{
    private List<Product> productList = new ArrayList<>();
    private int count;

    public void add(Product p)
    {
        productList.add(p);
        count++;
    }

    public int getCount()
    {
        return count;
    }
}
