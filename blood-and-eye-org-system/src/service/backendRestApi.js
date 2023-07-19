import axios from "@/axios";

class restAPI {
  async registrationBloodOrg(accountClass) {
    try {
      return await axios.post(
        "auth/organization/blood-registration",
        accountClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async loginBloodOrg(LoginRequestClass) {
    try {
      return await axios.post("auth/organization/token", LoginRequestClass);
    } catch (error) {
      console.log(error);
    }
  }

  async searchBloodByDivision(searchValue) {
    try {
      return await axios.get(
        "user/bloodusers/all-blood-organization-in-division" ,{
          params: {
            division: searchValue
          }
        }
      );
    } catch (error) {
      console.log(error);
    }
  }

  async searchBloodByDistric(searchValue) {
    try {
      return await axios.get(
        "user/bloodusers/all-blood-organization-in-distric" ,{
          params: {
            distric: searchValue
          }
        }
      );
    } catch (error) {
      console.log(error);
    }
  }

  async searchBloodByUpazila(searchValue) {
    try {
      return await axios.get(
        "user/bloodusers/all-blood-organization-in-upazila" ,{
          params: {
            upazila: searchValue
          }
        }
      );
    } catch (error) {
      console.log(error);
    }
  }

  async searchBloodByBloodType(searchValue) {
    try {
      return await axios.get(
        "user/bloodusers/all-blood-organization-in-bloodtype" ,{
          params: {
            bloodtype: searchValue
          }
        }
      );
    } catch (error) {
      console.log(error);
    }
  }

  async sendBloodRequest(BloodRequestClass  ) {
    try {
      return await axios.post(
        "user/bloodusers/send-request",
        BloodRequestClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async bloodOrgProfilePage() {
    try {
      return await axios.get("organization/bloodorganization/profile");
    } catch (error) {
      console.log(error);
    }
  }

  async deleteAccount() {
    try {
      return await axios.delete(
        "organization/bloodorganization/delete-account"
      );
    } catch (error) {
      console.log(error);
    }
  }

  async addBloodDonors(DonarInfoClass) {
    try {
      return await axios.post(
        "organization/bloodorganization/save-donor",
        DonarInfoClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async donorsList() {
    try {
      return await axios.get("organization/bloodorganization/get-all-donors");
    } catch (error) {
      console.log(error);
    }
  }

  async deleteDonorInfo(donorId) {
    try {
      return await axios.delete("organization/bloodorganization/delete-donor" ,{
        params: {
          donarId: donorId
        }
      });
    } catch (error) {
      console.log(error);
    }
  }

  async fourMonthComDonorList() {
    try {
      return await axios.get(
        "organization/bloodorganization/four-month-complete-donors"
      );
    } catch (error) {
      console.log(error);
    }
  }

  async sendEmailToDonor() {
    try {
      return await axios.post(
        "organization/bloodorganization/send-message-to-donors"
      );
    } catch (error) {
      console.log(error);
    }
  }

  async deliveryRequest(DeliveryRequestClass) {
    try {
      return await axios.post(
        "organization/bloodorganization/delivery-request",
        DeliveryRequestClass
      );
    } catch (error) {
      console.log(error);
    }
  }

  async deliveryRequestList() {
    try {
      return await axios.get(
        "organization/bloodorganization/all-delivery-requests"
      );
    } catch (error) {
      console.log(error);
    }
  }

  async bloodReqList() {
    try {
      return await axios.get("organization/bloodorganization/blood-request");
    } catch (error) {
      console.log(error);
    }
  }
}
export default new restAPI();
