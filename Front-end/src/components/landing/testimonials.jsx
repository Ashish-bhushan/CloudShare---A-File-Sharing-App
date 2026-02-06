const TestimonialSection = ({ testimonials }) => {
  return (
    <section className="py-28 bg-white">
      <div className="max-w-7xl mx-auto px-6">
        {/* Header */}
        <div className="max-w-3xl mx-auto text-center">
          <h2 className="text-4xl md:text-5xl font-extrabold text-gray-900">
            Trusted by professionals worldwide
          </h2>
          <p className="mt-4 text-lg text-gray-600">
            Teams of all sizes rely on CloudShare to manage and share their files securely.
          </p>
        </div>

        {/* Testimonials Grid */}
        <div className="mt-20 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
          {testimonials.map((testimonial, index) => (
            <figure
              key={index}
              className="group relative flex h-full flex-col rounded-3xl bg-gray-50 p-8 shadow-sm transition-all duration-300
                         hover:-translate-y-1 hover:shadow-xl"
            >
              {/* Quote */}
              <blockquote className="text-gray-700 leading-relaxed text-base">
                “{testimonial.quote}”
              </blockquote>

              {/* Divider */}
              <div className="my-8 h-px bg-gray-200" />

              {/* Author */}
              <figcaption className="mt-auto flex items-center gap-4">
                <img
                  src={testimonial.image}
                  alt={testimonial.name}
                  className="h-12 w-12 rounded-full object-cover"
                  loading="lazy"
                />

                <div>
                  <p className="font-semibold text-gray-900">
                    {testimonial.name}
                  </p>
                  <p className="text-sm text-gray-600">
                    {testimonial.role} · {testimonial.company}
                  </p>
                </div>
              </figcaption>

              {/* Rating */}
              <div className="absolute top-6 right-6 flex gap-1">
                {Array.from({ length: testimonial.rating }).map((_, i) => (
                  <span key={i} className="text-gray-900 text-sm">★</span>
                ))}
                {Array.from({ length: 5 - testimonial.rating }).map((_, i) => (
                  <span key={i} className="text-gray-300 text-sm">★</span>
                ))}
              </div>
            </figure>
          ))}
        </div>
      </div>
    </section>
  );
};

export default TestimonialSection;
