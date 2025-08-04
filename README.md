# Summer Clothing Sales Prediction on Wish E-commerce Platform

This repository contains the final project for the Data Mining Framework course at International University - Vietnam National University HCMC. Our objective is to apply data mining techniques to analyze and predict the sales performance of summer clothing products on the Wish platform using classification and regression models.

## Table of Contents

- [Project Overview](#project-overview)
- [Team Members](#team-members)
- [Dataset Description](#dataset-description)
- [Pre-processing](#pre-processing)
- [Models and Algorithms](#models-and-algorithms)
- [Evaluation](#evaluation)
- [Future Work](#future-work)
- [Getting Started](#getting-started)

---

## Project Overview

With the increasing complexity of customer behavior in e-commerce, particularly in the fashion industry, our goal is to explore sales trends and build predictive models to support business decisions such as inventory planning and marketing strategies.

We applied both classification and regression techniques to understand what influences product performance (units sold and rating) on the Wish platform.

---

## Team Members

| Name              | Student ID  | Role   | Contribution |
| ----------------- | ----------- | ------ | ------------ |
| Nguyễn Minh Quân  | ITDSIU20094 | Leader | 20%          |
| Nguyễn Mai Phương | ITDSIU20105 | Member | 20%          |
| Phan Thế Thiện    | ITDSIU20084 | Member | 20%          |
| Mai Quốc Bình     | ITDSIU21077 | Member | 20%          |
| Đồng Minh Thắng   | ITITIU20303 | Member | 20%          |

## Dataset Description

- **Source**: Wish e-commerce platform
- **Entries**: 1,573 products
- **Attributes**: 43 attributes including product details, pricing, marketing tags, and performance metrics

### Sample Attributes:

- Product name, color, origin
- Original and discounted price
- Units sold, product rating (1–5)
- Shipping info, tags, categories

### Potential Uses:

- Predict product performance
- Identify sales-driving features
- Optimize marketing and inventory
- Understand consumer behavior trends

---

## Pre-processing

- **Missing Value Imputation**: Filled nulls in has_urgency_banner with 0. Replaced nulls in all rating-related columns with 0 for products that had no ratings.
- **Data Cleaning & Feature Engineering**: Dropped unnecessary columns like IDs, URLs, and currency_buyer. Created new categorical features, including performance (based on units_sold), rating_range , and merchant_rating_range to aid analysis.
- **Data Visualization:** Used bar plots, pie charts, and a correlation heatmap to explore product performance, variable distributions, and the relationships between features.

---

## Models

- Naive Bayes
- Random Tree (Random Forest)
- J48 (C4.5)
- SMO (SVM)
- IBk (k-NN)
- ZeroR, OneR (baseline models)

---

## Evaluation

| Model        | Accuracy | Precision | Recall | F1-Score | Runtime (s) |
| ------------ | -------- | --------- | ------ | -------- | ----------- |
| J48 Pruned   | 0.9034   | 0.8936    | 0.6667 | 0.7636   | 0.33        |
| J48 Unpruned | 0.9072   | 0.8108    | 0.7143 | 0.7595   | 0.34        |
| NaiveBayes   | 0.8856   | 0.7559    | 0.7619 | 0.7589   | 0.22        |
| RandomTree   | 0.8989   | 0.7422    | 0.7540 | 0.7480   | 0.27        |
| SMO          | 0.6802   | 0.9836    | 0.4762 | 0.6417   | 0.61        |
| IBK          | 0.7190   | 0.8690    | 0.5794 | 0.6952   | 0.36        |

### Highlights:

- **J48 Unpruned** achieved the highest accuracy (90.72%) but showed signs of overfitting.
- **J48 Pruned** offered the best F1-Score (0.7636) with balanced performance overall.
- **NaiveBayes** was fast and efficient, with good results despite slightly lower accuracy.
- **RandomTree** performed well but had lower stability in precision and recall.
- **SMO** showed very high precision but poor recall, indicating class imbalance issues.
- **IBk** had moderate accuracy but decent F1-Score, with slightly longer runtime.

---

## Future Work

- Improve performance with oversampling (SMOTE) and undersampling (NearMiss)
- Explore ensemble methods and deep learning approaches

## Getting Started

This project is developed in Java using Visual Studio Code.

### Prerequisites:

- Java Development Kit (JDK)
- Visual Studio Code with Java extensions
- WEKA (for model training and evaluation)

### How to Run:

1. Clone the repository
2. Import the project into VS Code
3. Compile and run the Java files from the `src` folder
4. Use WEKA for model building if applicable
