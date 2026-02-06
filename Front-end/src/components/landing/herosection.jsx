import { assets } from "../../assets/assets";

const HeroSection = ({openSignIn,openSignUp}) => {
  return (
    <section className="relative overflow-hidden">
      <div className="max-w-7xl mx-auto px-6 py-28 text-center">
        <span className="inline-block mb-4 px-4 py-1 text-sm font-medium rounded-full bg-indigo-100 text-indigo-700">
          Launch Faster 🚀
        </span>

        <h1 className="text-5xl md:text-6xl font-extrabold text-gray-900 leading-tight">
          Share Files Securely With <br />
          <span className="text-indigo-600">Cloud Share</span>
        </h1>

        <p className="mt-6 max-w-2xl mx-auto text-lg text-gray-600">
          Upload, manage, and share your files securely. Accessible anywhere, anytime.
        </p>

        <div className="mt-10 flex justify-center gap-4">
          <button onClick={()=> openSignUp()}
              className="px-8 py-4 bg-indigo-600 text-white rounded-xl font-semibold hover:bg-indigo-700 transition shadow-lg">
            Sign Up
          </button>
          <button  onClick={()=> openSignIn()} 
              className="px-8 py-4 bg-white text-gray-900 rounded-xl font-semibold border hover:bg-gray-50 transition">
            Sign In
          </button>
        </div>
      </div>


    <div className="relative">

        <div className="aspect-w-16 rounded-lg shadow-xl overflow-hidden">
                <img src={assets.dashboad} alt="cloudshare dashboard" className="w-full h-full object-cover"></img>
        </div>
        <div className="absolute insert-0 bg-gradient-to-t from-black opacity-10 rounded-lg"></div>
    </div>


    <div className="mt-8 text-center">
        <p className="mt-4 text-base text-grey-500">
            All your files are encrypted and stored securely with enterprise-grade security protocols.
        </p>

    </div>



    </section>
  );
};

export default HeroSection;
