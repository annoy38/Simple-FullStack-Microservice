<template>
  <div class="container">
    <h1>Four Month Completed Donors</h1>
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <div class="container">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Donar Name</th>
            <th scope="col">Donar Email</th>
            <th scope="col">Donar Age</th>
            <th scope="col">Donar Gender</th>
            <th scope="col">Donar Address</th>
            <th scope="col">Donar Blood Group</th>
            <th scope="col">Blood Donate Date</th>
            <th scope="col">Donar Status</th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="table-success"
            v-for="donor in donorList"
            :key="donor.DonarInfoClass.donarId"
          >
            <th scope="row">{{ donor.DonarInfoClass.donarName }}</th>
            <td>{{ donor.DonarInfoClass.donarEmail }}</td>
            <td>{{ donor.DonarInfoClass.donarAge }}</td>
            <td>{{ donor.DonarInfoClass.donarGender }}</td>
            <td>{{ donor.DonarInfoClass.donarAddress }}</td>
            <td>{{ donor.DonarInfoClass.donarBloodType }}</td>
            <td>{{ donor.DonarInfoClass.localDate }}</td>
            <td>{{ donor.DonarInfoClass.status }}</td>
          </tr>
        </tbody>
      </table>
      <button type="button" @click="sendMail()" class="btn btn-success">
        Send Email
      </button>
    </div>
  </div>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "fourMonthCom",
  data() {
    return {
      donorList: [],
      showAlert: "",
      alertMessage: "",
    };
  },
  created() {
    this.fetchFourMonthComDonors();
  },
  methods: {
    async fetchFourMonthComDonors() {
      try {
        const response = await backendRestApi.fourMonthComDonorList();
        this.donorList = response.data.map((donor) => ({
          DonarInfoClass: {
            donarId: donor.donarId || "",
            bloodOrganizationId: donor.bloodOrganizationId || "",
            donarName: donor.donarName || "",
            donarEmail: donor.donarEmail || "",
            donarAge: donor.donarAge || "",
            donarGender: donor.donarGender || "",
            donarAddress: donor.donarAddress || "",
            donarBloodType: donor.donarBloodType || "",
            localDate: donor.localDate || "",
            status: donor.status || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },

    async sendMail() {
      try {
        const response = await backendRestApi.sendEmailToDonor();
        this.showAlert = true;
        this.alertMessage = response.data;
        setTimeout(() => {
          this.$router.push(
            "/blood-org-deshboard/blood-four-month-completed-donor-list"
          );
          this.showAlert = false;
          this.alertMessage = ""; // Redirect to the dashboard page
        }, 3000);
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
