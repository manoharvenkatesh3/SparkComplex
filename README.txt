**README**

## Data Pipeline Setup and Usage Instructions

### Overview
This data pipeline is designed to transform and analyze sales data, incorporating additional user data and weather information. It performs various data manipulation tasks and aggregations to derive insights from the data.

### Components and Functionality
1. **Python Script**: The main script (`sales_data_pipeline.py`) contains the data processing logic. It reads the sales data from a CSV file, fetches additional user data from a REST API, retrieves weather data based on geographical coordinates, performs data transformation and aggregation tasks, and stores the transformed data in a SQLite database.

2. **CSV File**: The sales data is provided in a CSV file (`sales_data.csv`). It includes information about orders, customers, products, quantities, prices, and order dates.

3. **REST API**: The pipeline interacts with a REST API (JSONPlaceholder) to fetch additional user data based on customer IDs.

4. **OpenWeatherMap API**: Weather data is obtained from the OpenWeatherMap API based on latitude and longitude coordinates extracted from the user data.

5. **SQLite Database**: The transformed and aggregated data is stored in a SQLite database (`sales_analytics_database.db`). It includes tables such as `customer_sales`, `Average_product_quantity`, `Top_Customers`, `Top_Products`, `Month_Sales_Trend`, `Quarterly_Sales`, and `Avg_Sales_Weather`.

### Dependencies
- Python 3.x
- pandas
- requests
- sqlalchemy
- pyodbc (if using SQL Server)
- matplotlib

### Setup Instructions
1. Install Python 3.x and ensure that pip is installed.
2. Install the required dependencies using the following command:
   ```
   pip install pandas requests sqlalchemy pyodbc matplotlib
   ```
3. Obtain API keys for the JSONPlaceholder API and OpenWeatherMap API, and set them as environment variables (`JSONPLACEHOLDER_API_KEY` and `OPENWEATHERMAP_API_KEY`).
4. Place the sales data CSV file (`sales_data.csv`) in the appropriate directory.
5. Run the `sales_data_pipeline.py` script to execute the data pipeline.

### Usage
1. Execute the `sales_data_pipeline.py` script to start the data pipeline.
2. Monitor the console for any output messages or errors.
3. After execution, check the SQLite database (`sales_analytics_database.db`) for the transformed and aggregated data.

## Database Schema
The database schema used to store the transformed and aggregated data is as follows:

1. `customer_sales`: Contains information about total sales amount per customer.
   - Columns: `customer_id`, `Customer_Name`, `Total_sales_amt_per_customer`

2. `Average_product_quantity`: Contains information about the average order quantity per product.
   - Columns: `customer_id`, `product_id`, `avg_order_quantity`

3. `Top_Customers`: Contains information about the top 5 customers based on total sales.
   - Columns: `customer_id`, `Customer_Name`, `Total_sales_amt_per_customer`

4. `Top_Products`: Contains information about the top 5 products based on total sales.
   - Columns: `product_id`, `customer_id`, `total_sales_prod_by_cust`

5. `Month_Sales_Trend`: Contains information about monthly sales trends.
   - Columns: `order_date`, `sales_amount`

6. `Quarterly_Sales`: Contains information about quarterly sales trends.
   - Columns: `order_date`, `sales_amount`

7. `Avg_Sales_Weather`: Contains information about average sales amount per weather condition.
   - Columns: `weather_condition`, `avg_sales`
