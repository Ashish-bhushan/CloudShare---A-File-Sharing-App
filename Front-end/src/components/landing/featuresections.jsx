// const features = [
//   { title: "Fast Uploads", desc: "Upload and share large files instantly." },
//   { title: "Secure Storage", desc: "Enterprise-grade encryption for your data." },
//   { title: "Team Collaboration", desc: "Work together in real time." },
//   { title: "Cloud Access", desc: "Access your files anywhere, anytime." },
// ];
import * as Icons from "lucide-react";

const FeatureSection = ({ features }) => {
  return (
    <section className="py-24">
      <div className="max-w-7xl mx-auto px-6">
        <h2 className="text-4xl font-bold text-center text-gray-900">
          Everything you need for file sharing
        </h2>

        <p className="text-center text-gray-600 mt-4">
          CloudShare provides all the tools you need to manage your digital content
        </p>

        <div className="mt-16 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
          {features.map((feature) => {
            const Icon = Icons[feature.iconName] || Icons.HelpCircle;

            return (
              <div
                key={feature.id}
                className="group relative overflow-hidden rounded-2xl bg-white p-8 shadow-md transition-all duration-300 hover:-translate-y-2 hover:shadow-2xl"
              >
                {/* glow */}
                <div className="pointer-events-none absolute inset-0 opacity-0 group-hover:opacity-100 transition">
                  <div
                    className="absolute -top-1/2 -left-1/2 h-full w-full rounded-full blur-3xl"
                    style={{ backgroundColor: feature.iconColor }}
                  />
                </div>

                <div className="relative z-10">
                  <div
                    className="mb-6 flex h-14 w-14 items-center justify-center rounded-xl"
                    style={{ backgroundColor: `${feature.iconColor}20` }}
                  >
                    <Icon size={28} style={{ color: feature.iconColor }} />
                  </div>

                  <h3 className="text-xl font-bold text-gray-900">
                    {feature.title}
                  </h3>

                  <p className="mt-3 text-gray-600 leading-relaxed">
                    {feature.description}
                  </p>
                </div>
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
};

export default FeatureSection;
