<template>

<div class="container">
    <h1>Send Eye Delivery Request</h1>
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <div class="row mb-4">
      <div class="col mt-5">
        <form @submit="sendDeliveryRequest($event)">
          <div class="form-group row mt-5">
            <label for="patientName" class="col-sm-5 col-form-label text-dark"
              >Enter Patient Name:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientName"
                v-model="DeliveryRequestClass.patientName"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="patientNumber" class="col-sm-5 col-form-label text-dark"
              >Enter Patient Number:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientNumber"
                v-model="DeliveryRequestClass.patientNumber"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="hospitalName" class="col-sm-5 col-form-label text-dark"
              >Enter Patient Hospital Name:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="hospitalName"
                v-model="DeliveryRequestClass.hospitalName"
                required
              />
            </div>
          </div>

          <button type="submit" class="btn btn-success mt-5">
            Send Request
          </button>
        </form>
      </div>
    </div>
  </div>

</template>

<script>
import backendEyeRestApi from '@/service/backendEyeRestApi';
export default{
    name: "eyeDeliveryReq",
    data() {
    return {
      DeliveryRequestClass: {
        patientName: "",
        patientNumber: "",
        hospitalName: "",
      },
      showAlert: "",
      alertMessage: "",
    };
  },
  methods: {
    sendDeliveryRequest(event) {
      event.preventDefault();
        backendEyeRestApi.eyeDeliveryRequest(this.DeliveryRequestClass)
        .then((response) => {
          if (response.data) {
            this.showAlert = true;
            this.alertMessage = "Request Send Successfully";
            setTimeout(() => {
              this.showAlert = false;
              this.alertMessage = "";
              this.DeliveryRequestClass = {
                patientName: "",
                patientNumber: "",
                hospitalName: "",
              };
            }, 3000);
          }
        })
        .catch((error) => {
          this.showAlert = true;
          this.alertMessage = "Error adding donor: " + error.message;
        });
    },
  },
}
</script>

<style>



</style>