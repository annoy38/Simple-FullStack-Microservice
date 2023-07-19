<template>
  <div class="container mt-4">
    <div class="row mt-4">
      <div class="col">
        <div class="card text-white bg-primary mb-3" style="max-width: 18rem">
          <div class="card-header">Total Blood Donation Bank</div>
          <div class="card-body">
            <h5 class="card-title">{{ totalBloodOrg }}</h5>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card text-white bg-success mb-3" style="max-width: 18rem">
          <div class="card-header">Total Blood Donor</div>
          <div class="card-body">
            <h5 class="card-title">{{ totalBloodDonor }}</h5>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card text-white bg-warning mb-3" style="max-width: 18rem">
          <div class="card-header">Total Eye Donation Bank</div>
          <div class="card-body">
            <h5 class="card-title">{{ totalEyeOrg }}</h5>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card text-white bg-info mb-3" style="max-width: 18rem">
          <div class="card-header">Total Eye Donor</div>
          <div class="card-body">
            <h5 class="card-title">{{ totalEyeDonor }}</h5>
          </div>
        </div>
      </div>
    </div>
    <div class="mt-5">
      <h2>Delivery Request Lists</h2>
    </div>
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <table class="table table-hover mt-4">
      <thead>
        <tr>
          <th scope="col">Donation Bank ID</th>
          <th scope="col">Donation Bank Name</th>
          <th scope="col">Donation Bank Number</th>
          <th scope="col">Donation Bank Location</th>
          <th scope="col">Patient Name</th>
          <th scope="col">Patient Number</th>
          <th scope="col">Hospital Name</th>
          <th scope="col">Delivery Iteam</th>
          <th scope="col">Delivery Status</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
      <tbody>
        <tr
          class="table-success"
          v-for="requestList in deliveryReqList"
          :key="requestList.DeliveryRequestsClass.deliverId"
        >
          <th scope="row">
            {{ requestList.DeliveryRequestsClass.organizationId }}
          </th>
          <td>{{ requestList.DeliveryRequestsClass.organizationName }}</td>
          <td>{{ requestList.DeliveryRequestsClass.organizationNumber }}</td>
          <td>{{ requestList.DeliveryRequestsClass.organizationLocation }}</td>
          <td>{{ requestList.DeliveryRequestsClass.patientName }}</td>
          <td>{{ requestList.DeliveryRequestsClass.patientNumber }}</td>
          <td>{{ requestList.DeliveryRequestsClass.hospitalName }}</td>
          <td>{{ requestList.DeliveryRequestsClass.deliverItem }}</td>
          <td>{{ requestList.DeliveryRequestsClass.status }}</td>
          <td>
            <button
            v-if="requestList.DeliveryRequestsClass.status=='Incomplete'"
              type="button"
              @click="
                updateAction(
                  requestList.DeliveryRequestsClass.deliverId,
                  updateStatus
                )
              "
              class="btn btn-success"
            >
              Complete
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import backendAdminRestApi from "@/service/backendAdminRestApi";
export default {
  name: "adminHome",
  data() {
    return {
      deliveryReqList: [],
      totalBloodOrg: "",
      totalBloodDonor: "",
      totalEyeOrg: "",
      totalEyeDonor: "",
      updateStatus: "Complete",
      showAlert: false,
      alertMessage: "",
    };
  },
  created() {
    this.fetchTotalBloodOrg();
    this.fetchTotalBloodDonor();
    this.fetchTotalEyeOrg();
    this.fetchTotalEyeDonor();
    this.fetchDeliveryReqt();
  },
  methods: {
    async fetchTotalBloodOrg() {
      try {
        const response = await backendAdminRestApi.countBloodOrg();
        this.totalBloodOrg = response.data;
      } catch (error) {
        console.error(error);
      }
    },

    async fetchTotalBloodDonor() {
      try {
        const response = await backendAdminRestApi.countBloodDonor();
        this.totalBloodDonor = response.data;
      } catch (error) {
        console.error(error);
      }
    },

    async fetchTotalEyeOrg() {
      try {
        const response = await backendAdminRestApi.countEyeOrg();
        this.totalEyeOrg = response.data;
      } catch (error) {
        console.error(error);
      }
    },

    async fetchTotalEyeDonor() {
      try {
        const response = await backendAdminRestApi.countEyeDonor();
        this.totalEyeDonor = response.data;
      } catch (error) {
        console.error(error);
      }
    },

    async fetchDeliveryReqt() {
      try {
        const response = await backendAdminRestApi.deliveryReqList();
        this.deliveryReqList = response.data.map((requestList) => ({
          DeliveryRequestsClass: {
            deliverId: requestList.deliverId || "",
            organizationId: requestList.organizationId || "",
            organizationName: requestList.organizationName || "",
            organizationNumber: requestList.organizationNumber || "",
            organizationLocation: requestList.organizationLocation || "",
            patientName: requestList.patientName || "",
            patientNumber: requestList.patientNumber || "",
            hospitalName: requestList.hospitalName || "",
            deliverItem: requestList.deliverItem || "",
            status: requestList.status || "",
          },
        }));
      } catch (error) {
        console.error(error);
      }
    },

    async updateAction(deliveryId, updateStatus) {
      try {
        console.log(deliveryId, updateStatus);
        const response = await backendAdminRestApi.updateDeliveryStatus(
          deliveryId,
          updateStatus
        );
        this.showAlert = true;
        this.alertMessage = response.data;
        setTimeout(() => {
          
          this.showAlert = false;
          this.alertMessage = ""; // Redirect to the dashboard page
        }, 3000);
      } catch (error) {
        console.error("Error deleting donor:", error);
      }
    },
  },
};
</script>

<style></style>
