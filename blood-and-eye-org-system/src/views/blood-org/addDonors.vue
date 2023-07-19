<template>
  <div class="container">
    <h1>Add Donors</h1>
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <div class="row mb-4">
      <div class="col mt-5">
        <form @submit="adddonor($event)">
          <div class="form-group row mt-5">
            <label for="donarName" class="col-sm-5 col-form-label text-dark"
              >Enter Donar Name:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarName"
                v-model="DonarInfoClass.donarName"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarEmail" class="col-sm-5 col-form-label text-dark"
              >Donar Email:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarEmail"
                v-model="DonarInfoClass.donarEmail"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarAge" class="col-sm-5 col-form-label text-dark"
              >Donar Age :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarAge"
                v-model="DonarInfoClass.donarAge"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarGender" class="col-sm-5 col-form-label text-dark"
              >Doner Gender :</label
            >
            <div class="col-sm-6">
              <select
                class="form-control"
                v-model="DonarInfoClass.donarGender"
                id="donarGender"
              >
                <option selected>Select Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
              </select>
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarAddress" class="col-sm-5 col-form-label text-dark"
              >Donar Address :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarAddress"
                v-model="DonarInfoClass.donarAddress"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label
              for="donarBloodType"
              class="col-sm-5 col-form-label text-dark"
              >Blood Type :</label
            >
            <div class="col-sm-6">
              <select
                class="form-control"
                v-model="DonarInfoClass.donarBloodType"
                id="donarBloodType"
              >
                <option selected>Select Blood Type</option>
                <option value="A+">A+</option>
                <option value="A-">A-</option>
                <option value="B+">B+</option>
                <option value="B-">B-</option>
                <option value="AB+">AB+</option>
                <option value="AB-">AB-</option>
                <option value="O+">O+</option>
                <option value="O-">O-</option>
              </select>
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="localDate" class="col-sm-5 col-form-label text-dark"
              >Blood Donate Date :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="localDate"
                v-model="DonarInfoClass.localDate"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="status" class="col-sm-5 col-form-label text-dark"
              >Donar Status :</label
            >
            <div class="col-sm-6">
              <select
                class="form-control"
                v-model="DonarInfoClass.status"
                id="status"
              >
                <option selected>Select Status</option>
                <option value="ACTIVE">Active</option>
                <option value="DEACTIVE">Deactive</option>
              </select>
            </div>
          </div>

          <button type="submit" class="btn btn-success mt-5">Add Donor</button>
        </form>
      </div>
    </div>
    <!-- <router-view></router-view> -->
  </div>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "addDonors",
  data() {
    return {
      DonarInfoClass: {
        donarName: "",
        donarEmail: "",
        donarAge: "",
        donarGender: "",
        donarAddress: "",
        donarBloodType: "",
        localDate: "",
        status: "",
      },
      showAlert: "",
      alertMessage: "",
    };
  },
  methods: {
    adddonor(event) {
      event.preventDefault();
      backendRestApi
        .addBloodDonors(this.DonarInfoClass)
        .then((response) => {
          if (response.data) {
            this.showAlert = true;
            this.alertMessage = "Donor Added Successfully";
            setTimeout(() => {
              this.showAlert = false;
              this.alertMessage = "";
              this.DonarInfoClass = {
                donarName: "",
                donarEmail: "",
                donarAge: "",
                donarGender: "",
                donarAddress: "",
                donarBloodType: "",
                localDate: "",
                status: "",
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
};
</script>

<style></style>
