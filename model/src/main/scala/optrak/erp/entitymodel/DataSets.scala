package optrak.erp.entitymodel

import java.time.Instant
import java.util.UUID

/**
  * Created by tim on 25/03/17.
  * Copyright Tim Pigden, Hertford UK
  * DataSets are used to group sets of entities together.
  * This enables us, for example, to have a static or slow-moiving set of products
  * for one user but rapidly changing order set (or real-time data)
  * A dataset contains a set of uuids - for each of the data types.
  * These uuids are then in turn mapped onto the id of the stored item
  *
  */
object DataSets {

  type DataSetId = Int
  type ServiceSetId = Int
  type ServiceName = String
  type TenantId = String


  trait HasDataSet {
    def tenantId: TenantId
    def dataSetId: DataSetId
  }

  case class DataId(tenantId: TenantId, dataSetId: DataSetId) extends HasDataSet

  val dataSetServiceName = "dataSets"
  val containerServiceName = "containers"
  val laneServiceName = "lanes"
  val orderServiceName = "orders"
  val siteServiceName = "sites"
  val productServiceName = "products"
  val tripServiceName = "trips"

  val dataServices = List(containerServiceName, laneServiceName, orderServiceName,
    siteServiceName, productServiceName, tripServiceName)

  case class DataSet(tenantId: TenantId,
                     dataSetId: DataSetId,
                     created: Instant,
                     name: String,
                     description: Option[String],
                     serviceSets: Map[ServiceName, ServiceSetId],
                     active: Boolean
                    )
  case class DataSetInfo(name: String, description: Option[String])

}
