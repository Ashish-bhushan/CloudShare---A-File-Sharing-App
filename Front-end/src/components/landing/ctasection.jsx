const CtaSection = ({openSignUp}) => {
  return (
    <section className="bg-gradient-to-r from-indigo-600 to-purple-600 py-20">
      <div className="max-w-3xl mx-auto text-center px-6">
        {/* Heading */}
        <h2 className="text-4xl md:text-5xl font-extrabold text-white">
          Ready to take your file sharing to the next level?
        </h2>

        {/* Subheading */}
        <p className="mt-4 text-lg text-indigo-100">
          Join thousands of professionals and teams who trust CloudShare to manage their files securely and efficiently.
        </p>

        {/* Buttons */}
        <div className="mt-8 flex flex-col sm:flex-row justify-center gap-4">
          <a onClick={()=>openSignUp()}
            href="#"
            className="px-8 py-4 bg-white text-indigo-600 font-semibold rounded-lg shadow hover:bg-gray-100 transition"
          >
            SignUp
          </a>
          
        </div>

        {/* Subtle decorative element */}
        <div className="mt-12 relative">
          <div className="absolute -inset-16 bg-white opacity-10 rounded-full blur-3xl" />
        </div>
      </div>
    </section>
  );
};

export default CtaSection;
