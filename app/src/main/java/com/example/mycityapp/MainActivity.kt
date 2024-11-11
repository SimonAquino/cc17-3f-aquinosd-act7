import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.mycityapp.cafes.Cafe
import com.example.mycityapp.cafes.CafeActivity
import com.example.mycityapp.restaurants.Restaurant
import com.example.mycityapp.restaurants.RestaurantActivity
import com.example.mycityapp.shoppingcenters.ShoppingCenter
import com.example.mycityapp.shoppingcenters.ShoppingCenterActivity
import com.example.mycityapp.touristspots.TouristSpot
import com.example.mycityapp.touristspots.TouristSpotActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        val categories = listOf(
            "Restaurants",
            "Cafes",
            "Tourist Spots",
            "Shopping Centers"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> showRestaurants()
                1 -> showCafes()
                2 -> showTouristSpots()
                3 -> showShoppingCenters()
            }
        }
    }

    private fun showRestaurants() {
        val restaurants = listOf(
            Restaurant("Grumpy Joe", "Details about Grumpy Joe"),
            Restaurant("Volante", "Details about Volante"),
            Restaurant("Vizco's", "Details about Vizco's")
        )

        val intent = Intent(this, RestaurantActivity::class.java)
        intent.putExtra("restaurants", restaurants)
        startActivity(intent)
    }

    private fun showCafes() {
        val cafes = listOf(
            Cafe("Seollem Cafe", "Details about Seollem Cafe"),
            Cafe("Cafe by the Ruin", "Details about Cafe by the Ruin"),
            Cafe("Foam Coffee", "Details about Foam Coffee")
        )

        val intent = Intent(this, CafeActivity::class.java)
        intent.putExtra("cafes", cafes)
        startActivity(intent)
    }

    private fun showTouristSpots() {
        val touristSpots = listOf(
            TouristSpot("Camp John Hay", "Details about Camp John Hay"),
            TouristSpot("Burnham Park", "Details about Burnham Park"),
            TouristSpot("Mirador Sanctuary", "Details about Mirador Sanctuary")
        )

        val intent = Intent(this, TouristSpotActivity::class.java)
        intent.putExtra("touristSpots", touristSpots)
        startActivity(intent)
    }

    private fun showShoppingCenters() {
        val shoppingCenters = listOf(
            ShoppingCenter("SM Baguio", "Details about SM Baguio"),
            ShoppingCenter("Center Mall", "Details about Center Mall"),
            ShoppingCenter("Porta Baga", "Details about Porta Baga")
        )

        val intent = Intent(this, ShoppingCenterActivity::class.java)
        intent.putExtra("shoppingCenters", shoppingCenters)
        startActivity(intent)
    }
}