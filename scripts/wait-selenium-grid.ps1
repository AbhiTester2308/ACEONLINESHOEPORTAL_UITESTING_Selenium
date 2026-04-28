$ErrorActionPreference = 'Stop'

$url = if ($env:SELENIUM_STATUS_URL) { $env:SELENIUM_STATUS_URL } else { 'http://localhost:4444/status' }
$maxAttempts = if ($env:SELENIUM_WAIT_ATTEMPTS) { [int]$env:SELENIUM_WAIT_ATTEMPTS } else { 60 }
$sleepSeconds = if ($env:SELENIUM_WAIT_SLEEP_SECONDS) { [int]$env:SELENIUM_WAIT_SLEEP_SECONDS } else { 2 }

Write-Host "Waiting for Selenium Grid: $url"

for ($i = 0; $i -lt $maxAttempts; $i++) {
  try {
    $r = Invoke-RestMethod -TimeoutSec 2 -Uri $url
    if ($r.value.ready -eq $true) {
      Write-Host "Selenium Grid is ready."
      exit 0
    }
  } catch {
    # ignore and retry
  }

Start-Sleep -Seconds $sleepSeconds
}

Write-Host "Selenium Grid not ready after $($maxAttempts * $sleepSeconds) seconds."
exit 1

