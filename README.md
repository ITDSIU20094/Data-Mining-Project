# Summer Clothing Sales Prediction on Wish E-commerce Platform

This repository contains the final project for the Data Mining Framework course at International University - Vietnam National University HCMC. Our objective is to apply data mining techniques to analyze and predict the sales performance of summer clothing products on the Wish platform using classification and regression models.

## Table of Contents

- [Project Overview](#project-overview)
- [Dataset Description](#dataset-description)
- [Pre-processing](#pre-processing)
- [Models and Algorithms](#models-and-algorithms)
- [Evaluation](#evaluation)
- [Future Work](#future-work)
- [Getting Started](#getting-started)
- [Folder Structure](#folder-structure)
- [Dependency Management](#dependency-management)
- [Team Members](#team-members)

---

## Project Overview

With the increasing complexity of customer behavior in e-commerce, particularly in the fashion industry, our goal is to explore sales trends and build predictive models to support business decisions such as inventory planning and marketing strategies.

We applied both classification and regression techniques to understand what influences product performance (units sold and rating) on the Wish platform.

---

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

- Descriptive statistics for understanding data distribution
- Handled missing values via imputation or removal
- Removed duplicates and outliers (via IQR and Z-score)
- Data normalization and feature engineering
- Visualization via histograms, box plots, and heatmaps

---

## Models and Algorithms

### Classification Models (sales_level: Low, Medium, High)
- Naive Bayes
- Random Tree (Random Forest)
- J48 (C4.5)
- SMO (SVM)
- IBk (k-NN)
- ZeroR, OneR (baseline models)

### Regression Models
- Linear Regression
- Decision Tree Regression
- Support Vector Regression (SMOreg)

### Feature Selection Methods
- **Filter**: Information Gain
- **Wrapper**: Model-driven selection

---

## Evaluation

### Classification Metrics:
- Precision, Recall, F1-score, Accuracy

### Regression Metrics:
- MAE, RMSE, R²

### Highlights:
- **Best Classification Model**: J48 with 100% F1-score
- **Best Regression Model**: Decision Tree Regression (lowest RMSE)

---

## Future Work

- Improve performance with oversampling (SMOTE) and undersampling (NearMiss)
- Explore ensemble methods and deep learning approaches
- Apply cross-validation more extensively to prevent overfitting
