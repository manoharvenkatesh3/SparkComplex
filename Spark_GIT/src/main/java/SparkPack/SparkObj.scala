package SparkPack


  import org.apache.spark.sql.SparkSession
import scala.io.Source
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
object SparkObj {

	def main(args:Array[String]):Unit = {

			val spark = SparkSession.builder().appName("RandomAPI").master("local[*]").getOrCreate()
					spark.sparkContext.setLogLevel("error")


					val url = "https://randomuser.me/api/0.8/?results=10"

					val results = scala.io.Source.fromURL(url).mkString


					val rdd = spark.sparkContext.parallelize(List(results))
					val df = spark.read.json(rdd)
					df.show()
					df.printSchema()

					println()
					println("===============flatten DF================")
					println()

					val flatdf = df.select(col("nationality"),col("results"),col("seed"),col("version"))
					.withColumn("results",explode(col("results")))
			
					flatdf.show()
					flatdf.printSchema()
					
					println()
					println("===============changing back to source DataFrame================")
					println()
					
					val comlexdf = flatdf.groupBy("nationality","seed","version")
					.agg(collect_list("results")).alias("results")
					
					comlexdf.printSchema()
					comlexdf.show()

	}
}