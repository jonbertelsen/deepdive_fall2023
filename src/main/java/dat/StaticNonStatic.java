package dat;


import java.util.List;

public class StaticNonStatic
{
    public static void main(String[] args)
    {
         ProductList productList = new ProductList();

            Product p = new Product("Nike Pegasus", 1000);
            productList.add(p);
            productList.add(new Product("Adidias", 900));

            ProductList productList2 = new ProductList();
            productList2.add(new Product("Nike Pegasus II", 999));
            productList2.add(new Product("Adidias II", 899));
            productList2.add(new Product("Adidias III", 199));

        System.out.println("ProductList.getCount() = " + productList.getCount());
        System.out.println("ProductList2.getCount() = " + productList2.getCount());

    }

    // calculate the sum of all the prices in the list
    public static int sum(List<Product> productList)
    {
        int sum = 0;
        for (Product p : productList)
        {
            sum += p.getPrice();
        }
        return sum;
    }

    // calculate the average of all the prices in the list
    public static int avg(List<Product> productList)
    {
        return sum(productList) / productList.size();
    }

    // Find max price in the list using streams
    public static int max(List<Product> productList)
    {
        return productList
                .stream()
                .mapToInt(Product::getPrice)
                .max()
                .getAsInt();
    }

    // Find max price in the list using a for each loop
    public static int max2(List<Product> productList)
    {
        int max = 0;
        for (Product p : productList)
        {
            if (p.getPrice() > max)
            {
                max = p.getPrice();
            }
        }
        return max;
    }

}
