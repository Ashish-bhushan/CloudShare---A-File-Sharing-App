# ☁️ CloudShare – File Sharing & Management Platform

A **modern cloud-based file manager** that lets users securely upload, manage, and share files with anyone using a public link.  
Built with **React, Spring Boot, MongoDB, Tailwind CSS, and Clerk Authentication**, this project demonstrates a **production-grade full-stack architecture**.

---

## ✨ Features

🚀 **Upload Files to the Cloud**  
Upload documents, images, videos, and audio files effortlessly.

👀 **Preview Files Instantly**  
Preview supported file types directly in the browser.

⬇️ **Download Files Anytime**  
One-click secure downloads for private and public files.

🗑️ **Delete Files Securely**  
Users can delete only their own files.

🔐 **Public / Private Visibility Toggle**  
Control who can access your files.

🔗 **Share via Public Links**  
Generate unique shareable links for public files.

📂 **Grid & List View Modes**  
Switch between beautiful grid cards and clean list layout.

👤 **User-Based Access Control**  
Each user sees **only their own files**, powered by Clerk authentication.

🎟️ **Credit-Based Access System**  
Free users can upload **up to 5 files** (5 credits).  
Perfect foundation for premium subscriptions.

📱 **Fully Responsive UI**  
Looks stunning on desktop, tablet, and mobile.

---

## 🎯 Who Is This For?

✅ Developers building a **portfolio-worthy project**  
✅ Students learning **full-stack development**  
✅ Freelancers creating **custom cloud solutions**  
✅ Anyone wanting to understand **secure file sharing systems**

---

## 🧠 Tech Stack

### Frontend
- ⚛️ React
- 🎨 Tailwind CSS
- 🧩 Lucide Icons
- 🔐 Clerk Authentication

### Backend
- ☕ Spring Boot
- 🌱 Spring Security
- 🍃 MongoDB
- 📦 REST APIs

---

## 🏗️ Architecture Overview

Client (React + Tailwind)
|
| REST APIs
↓
Backend (Spring Boot)
|
| Data Storage
↓
MongoDB




Authentication is handled by **Clerk**, ensuring secure and scalable user management.

---

## 📸 UI Components

- `FileCard` – Grid view file component
- `FileListRow` – List view file row
- `UploadModal` – File upload interface
- `PreviewModal` – File preview popup
- `ShareLinkModal` – Public link generator

---

## 🔐 Authentication & Security

- Secure login/signup with **Clerk**
- User-specific file access
- Public links only for explicitly shared files
- Backend authorization checks for every request

---

## 🧪 Free Plan Limitation

| Plan | Upload Credits |
|-----|---------------|
| Free | 5 Files |
| Paid | Unlimited (future upgrade) |

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash

git clone https://github.com/Ashish-bhushan/cloudvault.git


🛣️ Future Enhancements



💳 Subscription plans

📊 Storage usage analytics

🗂️ Folder support

🧠 AI-powered file search

🌍 Multi-language support
