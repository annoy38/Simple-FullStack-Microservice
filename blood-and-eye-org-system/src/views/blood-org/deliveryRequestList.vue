<template>
  <div class="container">
    <h1>Blood Delivery Request List</h1>
    <div class="container">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Patient Name</th>
            <th scope="col">Patient Email</th>
            <th scope="col">Hospital Name</th>
            <th scope="col">Delivery Iteam</th>
            <th scope="col">Delivery Status</th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="table-success"
            v-for="delivery in deliveryReqList"
            :key="delivery.DeliveryRequestClass.deliverId"
          >
            <th scope="row">{{ delivery.DeliveryRequestClass.patientName }}</th>
            <td>{{ delivery.DeliveryRequestClass.patientNumber }}</td>
            <td>{{ delivery.DeliveryRequestClass.hospitalName }}</td>
            <td>{{ delivery.DeliveryRequestClass.deliverItem }}</td>
            <td>{{ delivery.DeliveryRequestClass.status }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "deliveryRequestList",
  data() {
    return {
      deliveryReqList: [],
    };
  },
  created() {
    this.fetchDeliveryRequests();
  },
  methods: {
    async fetchDeliveryRequests() {
      try {
        const response = await backendRestApi.deliveryRequestList();
        this.deliveryReqList = response.data.map((delivery) => ({
          DeliveryRequestClass: {
            deliverId: delivery.deliverId || "",
            organizationId: delivery.organizationId || "",
            organizationName: delivery.organizationName || "",
            organizationNumber: delivery.organizationNumber || "",
            organizationLocation: delivery.organizationLocation || "",
            patientName: delivery.patientName || "",
            patientNumber: delivery.patientNumber || "",
            hospitalName: delivery.hospitalName || "",
            deliverItem: delivery.deliverItem || "",
            status: delivery.status || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
