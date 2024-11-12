class RestaurantAdapter(context: Context, private val restaurants: List<Restaurant>) : ArrayAdapter<Restaurant>(context, R.layout.restaurant_list_item, restaurants) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.restaurant_list_item, parent, false)

        val restaurant = getItem(position)
        val restaurantImageView = view.findViewById<ImageView>(R.id.restaurant_image)
        val restaurantNameTextView = view.findViewById<TextView>(R.id.restaurant_name)

        // Load the restaurant image (replace with your image loading library)
        Glide.with(context).load(restaurant.imageUrl).into(restaurantImageView)

        restaurantNameTextView.text = restaurant.name

        return view
    }
}