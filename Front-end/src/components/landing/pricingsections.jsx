const PricingSection = ({ pricingPlans , openSignUp}) => {
  return (
    <section className="py-28">
      <div className="max-w-7xl mx-auto px-6">
        {/* Header */}
        <div className="text-center max-w-3xl mx-auto">
          <h2 className="text-4xl md:text-5xl font-extrabold text-gray-900">
            Simple & Transparent Pricing
          </h2>
          <p className="mt-4 text-lg text-gray-600">
            Choose a plan that fits your needs. Upgrade anytime as you grow.
          </p>
        </div>

        {/* Pricing Cards */}
        <div className="mt-20 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
          {pricingPlans.map((plan) => (
            <div
              key={plan.name}
              className={`group relative flex flex-col overflow-hidden rounded-3xl bg-white p-8 shadow-md transition-all duration-300
                hover:-translate-y-2 hover:shadow-2xl
                ${plan.highlighted ? "ring-2 ring-gray-900/10" : ""}
              `}
            >
              {/* Subtle hover overlay (no color change) */}
              <div className="pointer-events-none absolute inset-0 opacity-0 group-hover:opacity-100 transition">
                <div className="absolute inset-0 bg-gradient-to-br from-white/60 to-transparent" />
              </div>

              {/* Content */}
              <div className="relative z-10 flex flex-col h-full">
                {/* Badge */}
                {plan.highlighted && (
                  <span className="mb-4 w-fit rounded-full bg-gray-900 px-4 py-1 text-sm font-semibold text-white">
                    Most Popular
                  </span>
                )}

                {/* Plan name */}
                <h3 className="text-2xl font-bold text-gray-900">
                  {plan.name}
                </h3>

                {/* Description */}
                <p className="mt-2 text-gray-600">
                  {plan.description}
                </p>

                {/* Price */}
                <div className="mt-6 flex items-end gap-1">
                  <span className="text-4xl font-extrabold text-gray-900">
                    {plan.price}
                  </span>
                  <span className="text-gray-500 text-sm">/month</span>
                </div>

                {/* Divider */}
                <div className="my-8 h-px bg-gray-200" />

                {/* Features */}
                <ul className="space-y-4 text-gray-700">
                  {plan.features.map((feature) => (
                    <li key={feature} className="flex items-start gap-3">
                      <span className="mt-1 h-2 w-2 rounded-full bg-gray-900" />
                      <span>{feature}</span>
                    </li>
                  ))}
                </ul>

                {/* CTA */}
                <button
                  onClick={()=> openSignUp()}
                  className={`mt-auto w-full rounded-xl py-3 text-base font-semibold transition
                    ${
                      plan.highlighted
                        ? "bg-gray-900 text-white hover:bg-gray-800"
                        : "border border-gray-300 text-gray-900 hover:bg-gray-100"
                    }
                  `}
                >
                  {plan.cta}
                </button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default PricingSection;
