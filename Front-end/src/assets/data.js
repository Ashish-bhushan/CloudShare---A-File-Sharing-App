
export const features = [
  {
    id: 1,
    iconName: "CloudUpload",
    iconColor: "#3B82F6", // blue
    title: "Fast File Uploads",
    description: "Upload your files quickly and securely with optimized cloud infrastructure."
  },
  {
    id: 2,
    iconName: "ShieldCheck",
    iconColor: "#10B981", // green
    title: "Secure Storage",
    description: "All your data is encrypted and protected with industry-grade security standards."
  },
  {
    id: 3,
    iconName: "Share2",
    iconColor: "#F59E0B", // amber
    title: "Simple Sharing",
    description: "Share files with anyone using secure links that you control."
  },
  {
    id: 4,
    iconName: "CreditCard",
    iconColor: "#8B5CF6", // purple
    title: "Flexible Credits",
    description: "Pay only for what you use with our credit-based system"
  },
  {
    id: 5,
    iconName: "FileText",
    iconColor: "#EF4444", // red
    title: "File Management",
    description: "Organize, preview and manage your files from any device."
  },
  {
    id: 6,
    iconName: "Clock",
    iconColor: "#64748B", // gray
    title: "Transaction History",
    description: "Keep track of all your credit purchases and usage."
  }
];

export const pricingPlans = [
  {
    name: "Free",
    price: "₹0",
    description: "Perfect for getting started",
    features: [
      "5 file uploads",
      "Basic file sharing",
      "7-day file retention",
      "Email support"
    ],
    cta: "Get Started",
    highlighted: false
  },
  {
    name: "Premium",
    price: "₹999",
    description: "For individual with larger needs",
    features: [
      "500 file uploads",
      "Advanced file sharing",
      "30-day file retention",
      "priority email support",
      "File sharing"
    ],
    cta: "Go Premium",
    highlighted: true
  },
  {
    name: "Ultimate",
    price: "₹2500",
    description: "For teams and businesses",
    features: [
      "5000 file uploads",
      "Team sharing capabilities",
      "Unlimited file retention",
      "24/7 priority support",
      "Advanced analytics",
      "API access"
    ],
    cta: "Go Ultimate",
    highlighted: false
  }
];

export const testimonials = [
  {
    name: "Michael Chen",
    role: "Freelance Designer",
    company: "Self-employed",
    image: "https://randomuser.me/api/portraits/men/46.jpg",
    quote:
      "As a freelancer, I need to share large design files quickly and securely. This platform has completely streamlined my workflow and saved me hours every week.",
    rating: 5,
  },
  {
    name: "Priya Sharma",
    role: "Project Manager",
    company: "TechSolutions Ltd.",
    image: "https://randomuser.me/api/portraits/women/65.jpg",
    quote:
      "Managing project files across multiple teams used to be chaotic. Now everything is organized, accessible, and easy to collaborate on.",
    rating: 4,
  },
  {
    name: "Daniel Roberts",
    role: "Startup Founder",
    company: "LaunchBase",
    image: "https://randomuser.me/api/portraits/men/32.jpg",
    quote:
      "The simplicity and speed are unmatched. We onboarded our entire team in minutes and never looked back.",
    rating: 5,
  },
  
];
