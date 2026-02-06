import { BrowserRouter, Route, Routes } from "react-router-dom";
import Landing from "./pages/landing";
import Dashboard from "./pages/dashboard";
import Upload from "./pages/upload";
import MyFiles from "./pages/myfiles";
import Subscription from "./pages/subscription";
import Transaction from "./pages/transactions";
import { SignedIn, SignedOut, RedirectToSignIn } from "@clerk/clerk-react";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing />} />

        <Route
          path="/dashboard"
          element={
            <>
              <SignedIn><Dashboard /></SignedIn>
              <SignedOut><RedirectToSignIn /></SignedOut>
            </>
          }
        />

        <Route
          path="/upload"
          element={
            <>
              <SignedIn><Upload /></SignedIn>
              <SignedOut><RedirectToSignIn /></SignedOut>
            </>
          }
        />

        <Route
          path="/my-files"
          element={
            <>
              <SignedIn><MyFiles /></SignedIn>
              <SignedOut><RedirectToSignIn /></SignedOut>
            </>
          }
        />

        <Route
          path="/subscription"
          element={
            <>
              <SignedIn><Subscription /></SignedIn>
              <SignedOut><RedirectToSignIn /></SignedOut>
            </>
          }
        />

        <Route
          path="/transaction"
          element={
            <>
              <SignedIn><Transaction /></SignedIn>
              <SignedOut><RedirectToSignIn /></SignedOut>
            </>
          }
        />

        <Route path="*" element={<RedirectToSignIn />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
