<template>
  <div class="container">
    <h1 class="mt-4 text-dark">
      Send Blood Request to {{ this.bloodOrgName }}
    </h1>
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <div class="row mb-4">
      <div class="col">
        <img src="../../assets/istockphoto-538340960-170667a.jpg" alt="" />
      </div>
      <div class="col mt-5" v-if="this.BloodRequestClass.bloodOrganizationEmail">
        <form @submit="sendBloodReq($event)">
          <div class="form-group row mt-5">
            <label for="bloodOrgEmail" class="col-sm-5 col-form-label text-dark"
              >Enter Blood Organization Email:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="bloodOrgEmail"
                v-model="BloodRequestClass.bloodOrganizationEmail"
                readonly
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="patientName" class="col-sm-5 col-form-label text-dark"
              >Patient Name:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientName"
                v-model="BloodRequestClass.patientName"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="patientNumber" class="col-sm-5 col-form-label text-dark"
              >Patient Number :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientNumber"
                v-model="BloodRequestClass.patientNumber"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label
              for="patientAddress"
              class="col-sm-5 col-form-label text-dark"
              >Patient Address :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientAddress"
                v-model="BloodRequestClass.patientAddress"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="bloodGroup" class="col-sm-5 col-form-label text-dark"
              >Requested Blood Group:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="bloodGroup"
                v-model="BloodRequestClass.requestBloodType"
                readonly
              />
            </div>
          </div>

          <button type="submit" class="btn btn-success mt-5">
            Send Blood Request
          </button>
        </form>
      </div>
    </div>
  </div>
  <footer class="footer bg-success py-4">
    <div class="container text-center">
      <span class="text-muted">This is the footer content.</span>
    </div>
  </footer>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "bloodRequest",
  data() {
    return {
      BloodRequestClass: {
        bloodOrganizationEmail: "",
        patientName: "",
        patientNumber: "",
        patientAddress: "",
        requestBloodType: "",
      },
      bloodOrgName: "",
      showAlert: false,
      alertMessage: "",
    };
  },
  created() {
    this.bloodOrgName = this.$route.params.orgName;
    this.BloodRequestClass.bloodOrganizationEmail = this.$route.params.orgEmail;
    this.BloodRequestClass.requestBloodType = this.$route.params.bloodType;
  },
  methods: {
    async sendBloodReq(event) {
      event.preventDefault();
      backendRestApi
        .sendBloodRequest(this.BloodRequestClass)
        .then((response) => {
          if (response.data) {
            this.showAlert = true;
            this.alertMessage = "Blood Request Sended";
            setTimeout(() => {
              this.showAlert = false;
              this.alertMessage = "";
              this.BloodRequestClass = {
                bloodOrganizationEmail: "",
                patientName: "",
                patientNumber: "",
                patientAddress: "",
                requestBloodType: "",
              };
            }, 3000);
          }
        })
        .catch((error) => {
          this.showAlert = true;
          this.alertMessage = "Error : " + error.message;
        });
    },
  },
};
</script>

<style></style>

<!-- private String bloodOrganizationEmail;
private String patientName;
private String patientNumber;
private String patientAddress;
private String requestBloodType -->
