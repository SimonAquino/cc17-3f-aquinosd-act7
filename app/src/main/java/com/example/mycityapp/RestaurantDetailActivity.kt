class RestaurantDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_detail)

        val restaurant = intent.getParcelableExtra<Restaurant>("restaurant") ?: return

        val restaurantImageView = findViewById<ImageView>(R.id.restaurant_detail_image)
        val restaurantNameTextView = findViewById<TextView>(R.id.restaurant_detail_name)
        val restaurantDescriptionTextView = findViewById<TextView>(R.id.restaurant_detail_description)

        // Load the restaurant image
        Glide.with(this).load(restaurant.imageUrl).into(restaurantImageView)

        restaurantNameTextView.text = restaurant.name
        restaurantDescriptionTextView.text = restaurant.description
    }
}