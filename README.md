# Render Auto Suspender

Suspend the specified service on [render.com](https://render.com/).  
Running it in a cron job prevents the cost of the development server from forgetting to suspend.  

## Setup on Render.com

1. Create new cron job.

![](artworks/screenshot%202022-09-04%202.01.09.png)

2. Input `https://github.com/KazaKago/render_suspender` in Public Git repository.

![](artworks/screenshot%202022-09-04%202.01.16.png)

3. Set cron job, For example `0 0 * * *` (Daily at 12:00 AM UTC).

![](artworks/screenshot%202022-09-04%202.07.27.png)

4. Input Environment Variables.

- `RENDER_SERVICE_IDS`: Render service IDs you want to suspend. You can enter multiple entries separated by commas.
- `RENDRE_TOKEN`: Your [Render access token](https://render.com/docs/api#creating-an-api-key).

![](artworks/screenshot%202022-09-04%202.33.46.png)

## Warning

Currently (2022/09) Render API does NOT support database suspend and resume.  
Please note that you need to switch manually.  
