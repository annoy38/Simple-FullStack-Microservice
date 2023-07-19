import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/User-blood-bank/HomeView.vue";
import bloodBankHome from "../views/User-blood-bank/bloodBankHome";
import chatBotAI from "../views/chatBotAI";
import searchBlood from "../views/User-blood-bank/searchBlood";
import bloodRequest from "../views/User-blood-bank/bloodRequest";
import bloodOrgRegistration from "../views/User-blood-bank/bloodOrgRegistration";
import bloodOrgLogin from "../views/User-blood-bank/bloodOrgLogin";
import eyeBankHome from "../views/User-eye-bank/eyeBankHome";
import eyeSearch from "../views/User-eye-bank/eyeSearch";
import sendEyeRequest from "../views/User-eye-bank/sendEyeRequest";
import eyeOrgRegistration from "../views/User-eye-bank/eyeOrgRegistration";
import eyeOrgLogin from "../views/User-eye-bank/eyeOrgLogin";
import adminHome from "../views/admin/adminHome";
import bloodOrgProfile from "../views/blood-org/bloodOrgProfile";
import bloodOrgDeshboard from "../views/blood-org/bloodOrgDeshboard";
import addDonors from "../views/blood-org/addDonors";
import donarList from "../views/blood-org/donarList";
import fourMonthCom from "../views/blood-org/fourMonthCom";
import sendRequest from "../views/blood-org/sendRequest";
import deliveryRequestList from "../views/blood-org/deliveryRequestList";
import bloodReqNotification from "../views/blood-org/bloodReqNotification";
import eyeOrgDeshboard from "../views/eye-org/eyeOrgDeshboard";
import eyeOrgProfile from "../views/eye-org/eyeOrgProfile";
import addEyeDonors from "../views/eye-org/addEyeDonors";
import eyeDonorList from "../views/eye-org/eyeDonorList";
import eyeDeliveryReq from "../views/eye-org/eyeDeliveryReq";
import eyeDeliveryReqList from "../views/eye-org/eyeDeliveryReqList";
import eyeRequestList from "../views/eye-org/eyeRequestList";
import adminLogin from "../views/admin/adminLogin";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
    children: [
      {
        path: "/blood-bank-home",
        name: "bloodBankHome",
        component: bloodBankHome,
      },
      {
        path: "/search-blood",
        name: "searchBlood",
        component: searchBlood,
        children: [
          // {
          //   path: "/search-blood/blood-request",
          //   name: "bloodRequest",
          //   component: bloodRequest,
          // },
        ],
      },
      {
        path: "/blood-org-registration",
        name: "bloodOrgRegistration",
        component: bloodOrgRegistration,
      },
      {
        path: "/blood-org-login",
        name: "bloodOrgLogin",
        component: bloodOrgLogin,
      },
    ],
  },
  {
    path: "/eye-bank",
    name: "eyeBank",
    component: () => import("../views/User-eye-bank/eyeBank.vue"),
    children: [
      {
        path: "/eye-bank/eye-home",
        name: "eyeBankHome",
        component: eyeBankHome,
      },
      {
        path: "/eye-bank/eye-search",
        name: "eyeSearch",
        component: eyeSearch,
      },
      {
        path: "/eye-bank/eye-org-registration",
        name: "eyeOrgRegistration",
        component: eyeOrgRegistration,
      },
      {
        path: "/eye-bank/eye-org-login",
        name: "eyeOrgLogin",
        component: eyeOrgLogin,
      },
    ],
  },
  {
    path: "/chatbot",
    name: "chatBotAI",
    component: chatBotAI,
  },
  {
    path: "/send-eye-request/:orgName/:orgEmail",
    name: "sendEyeRequest",
    component: sendEyeRequest,
  },
  {
    path: "/blood-request/:orgName/:orgEmail/:bloodType",
    name: "bloodRequest",
    component: bloodRequest,
  },
  {
    path: "/blood-org-deshboard",
    name: "bloodOrgDeshboard",
    component: bloodOrgDeshboard,
    children: [
      {
        path: "blood-org-profile",
        name: "bloodOrgProfile",
        component: bloodOrgProfile,
      },
      {
        path: "blood-add-donor",
        name: "addDonors",
        component: addDonors,
      },
      {
        path: "blood-donor-list",
        name: "donarList",
        component: donarList,
      },
      {
        path: "blood-four-month-completed-donor-list",
        name: "fourMonthCom",
        component: fourMonthCom,
      },
      {
        path: "send-delivery-request",
        name: "sendRequest",
        component: sendRequest,
      },
      {
        path: "blood-delivery-request-list",
        name: "deliveryRequestList",
        component: deliveryRequestList,
      },
      {
        path: "blood-request-list",
        name: "bloodReqNotification",
        component: bloodReqNotification,
      },
    ],
  },

{
  path: "/eye-org-deshboard",
  name: "eyeOrgDeshboard",
  component: eyeOrgDeshboard,
  children: [
    {
      path: "eye-org-profile",
      name: "eyeOrgProfile",
      component: eyeOrgProfile
    },
    {
      path: "eye-add-donor",
      name: "addEyeDonors",
      component: addEyeDonors
    },
    {
      path: "eye-donor-list",
      name: "eyeDonorList",
      component: eyeDonorList
    },
    {
      path: "eye-delivery-request",
      name: "eyeDeliveryReq",
      component: eyeDeliveryReq
    },
    {
      path: "eye-delivery-request-list",
      name: "eyeDeliveryReqList",
      component: eyeDeliveryReqList
    },
    {
      path: "eye-request-list",
      name: "eyeRequestList",
      component: eyeRequestList
    }
  ]
},
{
  path: "/admin-login",
  name: "adminLogin",
  component: adminLogin
},
{
  path: "/admin-deshboard",
  name: "adminHome",
  component: adminHome,
},
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
