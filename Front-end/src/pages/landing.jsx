import { useClerk, useUser } from "@clerk/clerk-react";
import { features, pricingPlans , testimonials} from "../assets/data";
import CtaSection from "../components/landing/ctasection";
import FeatureSection from "../components/landing/featuresections";
import FooterSection from "../components/landing/footersection";
import HeroSection from "../components/landing/herosection";
import PricingSection from "../components/landing/pricingsections";
import TestimonialSection from "../components/landing/testimonials";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

const Landing = () =>
{
    const {openSignIn,openSignUp} = useClerk();
    const {isSignedIn} = useUser();
    const {navigate} = useNavigate();

    useEffect(()=>{

        if(isSignedIn)
        {
            navigate("/dashboard");
        }

    },[isSignedIn,navigate])
    return (
        <div className="landing-page bg-gradient-to-b from-gray-50 to-gray-100">
            
            {/*hero section */}  
            <HeroSection openSignIn = {openSignIn} openSignUp = {openSignUp} />

            {/*feature section */} 
            <FeatureSection features={features}/>

            {/*pricing section */}
            <PricingSection pricingPlans={pricingPlans} openSignUp = {openSignUp}/>

            {/*testimonials section */}  
            <TestimonialSection testimonials = {testimonials}/>

            {/*cta section */}  
            <CtaSection openSignUp = {openSignUp}/>

            {/*footer section */} 
            <FooterSection/>
             
        </div>
    )
}

export default Landing;